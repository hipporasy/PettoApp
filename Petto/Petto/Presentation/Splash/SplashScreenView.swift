//
//  SplashView.swift
//  Petto
//
//  Created by Marasy Phi on 20/3/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import UIKit

struct SplashScreenView: View {
    
    @State var isPresented: Bool = false
    
    var body: some View {
        VStack {
            GIFView(gifName: "pettogif")
            Spacer()
        }
        .onAppear(perform: {
            delayText()
        })
        .fullScreenCover(isPresented: $isPresented, content: { ContentView() })
        .background(Color.primaryBackground)
    }
    
    private func delayText() {
        
        DispatchQueue.main.asyncAfter(deadline: .now() + 4) {
            isPresented.toggle()
        }
    }
    
}

struct GIFView: UIViewRepresentable {
    
    var gifName: String

    func updateUIView(_ uiView: UIView, context: UIViewRepresentableContext<GIFView>) {

    }


    func makeUIView(context: Context) -> UIView {
        return GifImageView(gifName: gifName)
    }
}

