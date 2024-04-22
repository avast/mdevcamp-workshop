//
//  GithubRepository.swift
//  iosApp
//
//  Created by Martin Rajniak on 19/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation

struct GithubRepository : Codable {
    var id: Int
    var name: String
    var full_name: String
    var owner: User
    var description: String
}

extension GithubRepository {
    
    init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: CodingKeys.self)
        self.id = try container.decode(Int.self, forKey: .id)
        self.name = try container.decode(String.self, forKey: .name)
        self.full_name = try container.decode(String.self, forKey: .full_name)
        self.owner = try container.decode(User.self, forKey: .owner)
        self.description = try container.decodeIfPresent(String.self, forKey: .description) ?? ""
    }
}
