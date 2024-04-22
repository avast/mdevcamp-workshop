//
//  RepositoryView.swift
//  iosApp
//
//  Created by Lukáš Prokop on 06.01.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct RepositoryItemView: View {
    var repository: GithubRepository
    
    var body: some View {
        VStack(alignment: .leading) {
            Text(repository.name)
                .font(.title)
            Text(repository.description)
                .font(.subheadline)
        }.padding()
    }
}

#Preview {
    RepositoryItemView(repository: InMemoryRepository.repositories["avast"]![0])
}
