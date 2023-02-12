//
//  Enum+Extension.swift
//  Petto
//
//  Created by Rasy on 12/2/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import pettoCore

extension Array where Element: AnyObject {
    init(_ kotlinArray: KotlinArray<Element>) {
        self.init()
        let iterator = kotlinArray.iterator()
        while iterator.hasNext() {
            self.append(iterator.next() as! Element)
        }
    }
}

extension Pet.PetType {
    
    static var allCases: [Pet.PetType] {
        return Array(Pet.PetType.values())
    }
    
}
