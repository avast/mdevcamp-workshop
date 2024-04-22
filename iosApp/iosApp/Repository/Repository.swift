//
//  Repository.swift
//  iosApp
//
//  Created by Martin Rajniak on 19/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation

protocol Repository {
    
    func getUser(username: String) async throws -> User?

    func getUserRepository(username: String) async throws -> [GithubRepository]?
}
