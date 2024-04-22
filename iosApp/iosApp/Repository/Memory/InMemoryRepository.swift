//
//  InMemoryRepository.swift
//  iosApp
//
//  Created by Martin Rajniak on 19/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation

class InMemoryRepository : Repository {
    
    func getUser(username: String) async throws -> User? {
        return InMemoryRepository.users[username]
    }
    
    func getUserRepository(username: String) async throws -> [GithubRepository]? {
        return InMemoryRepository.repositories[username]
    }
    
    static let users : [String : User] = [
        "avast" : User(
            login : "avast",
            id : 3996079,
            avatarUrl : "https://avatars1.githubusercontent.com/u/3996079?v=4",
            gravatarId: "",
            url : "https://api.github.com/users/avast",
            htmlUrl : "https://github.com/avast",
            followersUrl : "https://api.github.com/users/avast/followers",
            followingUrl : "https://api.github.com/users/avast/following{/other_user}",
            publicRepos : 98,
            publicGists : 0,
            followers : 0,
            following : 0
        ),
        "inmite" : User(
            login : "inmite",
            id : 3819616,
            avatarUrl : "https://avatars1.githubusercontent.com/u/3819616?v=4",
            gravatarId: "",
            url : "https://api.github.com/users/inmite",
            htmlUrl : "https://github.com/inmite",
            followersUrl : "https://api.github.com/users/inmite/followers",
            followingUrl : "https://api.github.com/users/inmite/following{/other_user}",
            publicRepos : 10,
            publicGists : 0,
            followers : 0,
            following : 0
        ),
        "square" : User(
            login : "square",
            id : 82592,
            avatarUrl : "https://avatars0.githubusercontent.com/u/82592?v=4",
            gravatarId: "",
            url : "https://api.github.com/users/square",
            htmlUrl : "https://github.com/square",
            followersUrl : "https://api.github.com/users/square/followers",
            followingUrl : "https://api.github.com/users/square/following{/other_user}",
            publicRepos : 223,
            publicGists : 5,
            followers : 0,
            following : 0
        )
    ]
        
    static let repositories : [String : [GithubRepository]] = [
        "avast" : [
            GithubRepository(
                id : 15397085,
                name : "android-butterknife-zelezny",
                full_name : "avast/android-butterknife-zelezny",
                owner : users["avast"]!,
                description : "Android Studio plug-in for generating ButterKnife injections from selected layout XML."
            ),
            GithubRepository(
                id : 45212866,
                name : "android-lectures",
                full_name : "avast/android-lectures",
                owner : users["avast"]!,
                description : "Class material for lectures about Android development"
            ),
            GithubRepository(
                id : 10281119,
                name : "android-styled-dialogs",
                full_name : "avast/android-styled-dialogs",
                owner : users["avast"]!,
                description : "Class material for lectures about Android development"
            )
        ],
        "inmite" : [
            GithubRepository(
                id : 13663078,
                name : "android-validation-komensky",
                full_name : "inmite/android-validation-komensky",
                owner : users["inmite"]!,
                description : "A simple library for validating user input in forms using annotations."
            ),
            GithubRepository(
                id : 12222625,
                name : "android-selector-chapek",
                full_name : "inmite/android-selector-chapek",
                owner : users["inmite"]!,
                description : "Android Studio plugin which automatically generates drawable selectors from appropriately named resources."
            ),
            GithubRepository(
                id : 10281119,
                name : "android-grid-wichterle",
                full_name : "inmite/android-grid-wichterle",
                owner : users["inmite"]!,
                description : "This app will show grid overlay over whole system which helps you to verify your excellent app design."
            )
        ],
        "square" : [
            GithubRepository(
                id : 5152285,
                name : "okhttp",
                full_name : "square/okhttp",
                owner : users["square"]!,
                description : "An HTTP+HTTP/2 client for Android and Java applications."),
            GithubRepository(
                id : 892275,
                name : "retrofit",
                full_name : "square/retrofit",
                owner : users["square"]!,
                description : "Type-safe HTTP client for Android and Java by Square, Inc."
            )
        ]
    ]
}
