//
//  ProfileView.swift
//  Petto
//
//  Created by Marasy Phi on 30/3/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct ProfileView: View {
    
    @State var isNotification: Bool = false
    @State var isDarkMode: Bool = false
    
    var body: some View {
        ScrollView {
            VStack(alignment: .leading) {
                Text("Profiles")
                    .font(.system(size: 26))
                
                VStack(spacing: 20) {
                    Image("profile")
                        .resizable()
                        .scaledToFill()
                        .frame(width: 80, height: 80, alignment: .center)
                        .clipShape(Circle())
                    
                    Text("Luis Martin")
                        .font(.system(size: 22, weight: .medium))
                }
                .frame(maxWidth: .infinity, alignment: .center)
                .background(Color.primaryBackground)
                .clipShape(RoundedCorner(radius: 32, corners: [.bottomLeft, .bottomRight]))
                
                Divider()
                
                VStack {
                    ProfileRow {
                        HStack {
                            Image(systemName: "square.and.pencil")
                            Text("Adopted Form")
                            Spacer()
                        }
                    }
                    ProfileRow {
                        HStack {
                            Image(systemName: "pencil.circle")
                            Text("Submitted Form")
                            Spacer()
                        }
                    }
                    ProfileRow {
                        HStack {
                            Image(systemName: "questionmark.circle.fill")
                            Text("Help & Support")
                            Spacer()
                        }
                    }
                    ProfileRow {
                        HStack {
                            Text("Privacy Policy")
                            Spacer()
                        }
                    }
                    ProfileRow {
                        HStack {
                            Text("Terms and Condition")
                            Spacer()
                        }
                    }
                }
                Spacer()
            }
            .padding()
            .background(Color.primaryBackground)
            .frame(maxWidth: .infinity, alignment: .leading)
            .navigationBarHidden(true)
        }
    }
    
}

struct ProfileRow<Content: View> : View {
    
    private let _content: Content
    
    init(@ViewBuilder content: () -> Content) {
        self._content = content()
    }
    
    var body: some View {
        _content
            .padding()
            .frame(maxWidth: .infinity)
            .background(Color.white)
            .clipShape(RoundedRectangle(cornerRadius: 8))
            .shadow(color: Color.black.opacity(0.04),
                    radius: 8, x: 0, y: 3)
    }
    
}

struct ProfilePreviewProvider: PreviewProvider {
    
    static var previews: some View {
        ProfileView()
    }
    
}
