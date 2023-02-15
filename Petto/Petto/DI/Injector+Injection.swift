//
//  Injector+Injection.swift
//  Petto
//
//  Created by Rasy on 15/2/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

@propertyWrapper
struct Inject<Component> {
    let wrappedValue: Component
    init() {
        self.wrappedValue = Injector.shared.resolve(Component.self)
    }
}
