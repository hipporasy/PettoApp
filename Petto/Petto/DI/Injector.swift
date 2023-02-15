//
//  Injector.swift
//  Petto
//
//  Created by Rasy on 15/2/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import pettoCore
import Swinject

class Injector: CoreModule {
    
    static let shared = Injector.init()
    private var container: Container!
    
    private override init() {
        super.init()
        self.start { _ in
            
        }
        container = buildContainer(using: self)
    }
    
    func provide<UseCase: AbstractUseCase>(_ type: UseCase.Type) -> UseCase {
        return provides(cType: type) as! UseCase
    }
    
    func provide<Repository>(_ type: Protocol) -> Repository {
        return provides(pType: type) as! Repository
    }
    
    func resolve<T>(_ type: T.Type) -> T {
        container.resolve(T.self)!
    }
    
    func setDependencyContainer(_ container: Container) {
        self.container = container
    }
    
}
