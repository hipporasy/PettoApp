//
//  GifImageView.swift
//  Petto
//
//  Created by Marasy Phi on 20/3/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import UIKit

class GifImageView: UIView {
    private let imageView = UIImageView()

    convenience init(gifName: String) {
       self.init()
       let gif = UIImage.gif(asset: gifName)
       imageView.image = gif
       imageView.contentMode = .scaleAspectFit
       self.addSubview(imageView)
    }

    override init(frame: CGRect) {
       super.init(frame: frame)
    }

    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }

    override func layoutSubviews() {
        super.layoutSubviews()
        imageView.frame = bounds
    }
}
