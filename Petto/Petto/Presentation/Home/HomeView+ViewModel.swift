//
//  HomeViewModel.swift
//  Petto
//
//  Created by Rasy on 15/2/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import pettoCore
import Combine

extension HomeView {
    
    enum AppState {
        case initial
        case fetched
        case loading
    }
    
    class ViewModel: ObservableObject {
        
        @Published var pets: [Pet] = []
        @Published var selectedPetType: Pet.PetType = .dogs
        @Published var state: AppState = .initial
        @Inject private var useCase: FetchPetUseCase
        private var cancellable = Set<AnyCancellable>()
        

        @MainActor
        func loadPet() {
            Task {
                do {
                    let response = try await useCase.execute(params: selectedPetType)
                    response.fold { result in
                        self.pets = result?.cast() ?? []
                    } onFailure: { error in
                        print(error)
                    }

                } catch (let e) {
                    print(e)
                }

            }
        }
        
//        func loadProduct() {
//            state = .loading
//            repository
//                .fetchProducts()
//                .receive(on: RunLoop.main)
//                .sink(receiveCompletion: { status in
//                    self.state = .fetched
//                    switch status {
//                    case .failure(let error):
//                        print(error)
////                        self.state = .error(.other(error))
//                    case .finished:
//                        print("Success")
////                        self.state = .fetched
//                    }
//                },
//                      receiveValue: { (result) in
//                    self.products = result.products
//                })
//                .store(in: &cancellable)
//        }
        
    }
    
}
