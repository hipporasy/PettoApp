//
//  Container.swift
//  Petto
//
//  Created by Rasy on 15/2/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import Swinject
import pettoCore

func buildContainer(using injector: Injector) -> Container {
    let container = Container()
    
    container.registerViewModel()
    container.registerUseCase(injector)
    return container
}

private extension Container {
    
    func registerViewModel() {
        register(HomeView.ViewModel.self) { resolver in
            HomeView.ViewModel()
        }
    }
    
    func registerUseCase(_ injector: Injector) {
        register(FetchPetUseCase.self) { r in
            injector.provide(FetchPetUseCase.self)
        }
    }
    
}
