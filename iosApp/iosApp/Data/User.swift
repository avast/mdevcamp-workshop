//
//  User.swift
//  iosApp
//
//  Created by Martin Rajniak on 19/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation

struct User : Codable {
    var login: String
    var id: Int
    var avatarUrl: String
    var gravatarId: String
    var url: String
    var htmlUrl: String
    var followersUrl: String
    var followingUrl: String
    var publicRepos: Int
    var publicGists: Int
    var followers: Int
    var following: Int
    
    enum CodingKeys: String, CodingKey {
        case login
        case id
        case avatarUrl = "avatar_url"
        case gravatarId = "gravatar_id"
        case url
        case htmlUrl = "html_url"
        case followersUrl = "followers_url"
        case followingUrl = "following_url"
        case publicRepos = "public_repos"
        case publicGists = "public_gists"
        case followers
        case following
    }
}

extension User {
    
    init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: CodingKeys.self)
        self.login = try container.decode(String.self, forKey: .login)
        self.id = try container.decode(Int.self, forKey: .id)
        self.avatarUrl = try container.decode(String.self, forKey: .avatarUrl)
        self.gravatarId = try container.decodeIfPresent(String.self, forKey: .gravatarId) ?? ""
        self.url = try container.decode(String.self, forKey: .url)
        self.htmlUrl = try container.decode(String.self, forKey: .htmlUrl)
        self.followersUrl = try container.decode(String.self, forKey: .followersUrl)
        self.followingUrl = try container.decode(String.self, forKey: .followingUrl)
        self.publicRepos = try container.decodeIfPresent(Int.self, forKey: .publicRepos) ?? 0
        self.publicGists = try container.decodeIfPresent(Int.self, forKey: .publicGists) ?? 0
        self.followers = try container.decodeIfPresent(Int.self, forKey: .followers) ?? 0
        self.following = try container.decodeIfPresent(Int.self, forKey: .following) ?? 0
    }
}
