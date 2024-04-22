//
//  NetworkRepository.swift
//  iosApp
//
//  Created by Martin Rajniak on 20/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation

class NetworkRepository : Repository {
    
    func getUser(username: String) async throws -> User? {
        let url = URL(string: "https://api.github.com/users/\(username)")
        let request = URLRequest(url: url!)
        let (data, response) = try await URLSession.shared.data(for: request)
        let fetchedData = try JSONDecoder().decode(User.self, from: try mapResponse(response: (data,response)))
        return fetchedData
    }
    
    func getUserRepository(username: String) async throws -> [GithubRepository]? {
        let url = URL(string: "https://api.github.com/users/\(username)/repos")
        let request = URLRequest(url: url!)
        let (data, response) = try await URLSession.shared.data(for: request)
        let fetchedData = try JSONDecoder().decode(GithubRepositories.self, from: try mapResponse(response: (data,response)))
        return fetchedData
    }
    
    typealias GithubRepositories = [GithubRepository]
    
    public enum NetworkError: Error, LocalizedError {
        
        case missingRequiredFields(String)
        
        case invalidParameters(operation: String, parameters: [Any])
        
        case badRequest
        
        case unauthorized
        
        case paymentRequired
        
        case forbidden
        
        case notFound
        
        case requestEntityTooLarge

        case unprocessableEntity
        
        case http(httpResponse: HTTPURLResponse, data: Data)
        
        case invalidResponse(Data)
        
        case deleteOperationFailed(String)
        
        case network(URLError)
        
        case unknown(Error?)

    }
    
    func mapResponse(response: (data: Data, response: URLResponse)) throws -> Data {
        guard let httpResponse = response.response as? HTTPURLResponse else {
            return response.data
        }
        
        switch httpResponse.statusCode {
        case 200..<300:
            return response.data
        case 400:
            throw NetworkError.badRequest
        case 401:
            throw NetworkError.unauthorized
        case 402:
            throw NetworkError.paymentRequired
        case 403:
            throw NetworkError.forbidden
        case 404:
            throw NetworkError.notFound
        case 413:
            throw NetworkError.requestEntityTooLarge
        case 422:
            throw NetworkError.unprocessableEntity
        default:
            throw NetworkError.http(httpResponse: httpResponse, data: response.data)
        }
    }
}
