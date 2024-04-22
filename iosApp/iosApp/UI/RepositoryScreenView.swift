//
//  RepositoryScreenView.swift
//  iosApp
//
//  Created by Lukáš Prokop on 07.01.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct RepositoryScreenView: View {
    var repository: GithubRepository
    
    var body: some View {
        VStack(alignment: .leading) {
            Text(repository.name)
                .font(.title)
            Text(repository.owner.login)
                .font(.subheadline)
            Text(repository.description)
            Spacer()
        }.padding()
            .navigationTitle(repository.name)
    }
}

#Preview {
    RepositoryScreenView(repository: InMemoryRepository.repositories["avast"]![0])
}
