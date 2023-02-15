//
//  NSArray+Extension.swift
//  Petto
//
//  Created by Rasy on 15/2/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

extension NSArray {
    
    func cast<T>() -> [T] {
        return self.compactMap { $0 as? T } 
    }
}
