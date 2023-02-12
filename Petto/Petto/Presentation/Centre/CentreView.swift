//
//  CentreView.swift
//  PetAdoption
//
//  Created by Marasy Phi on 28/2/21.
//

import SwiftUI

struct CentreView: View {
    
    @State private var _tabBarController: UITabBarController? = nil
    
    var body: some View {
        VStack {
            ScrollView(.vertical, showsIndicators: /*@START_MENU_TOKEN@*/true/*@END_MENU_TOKEN@*/, content: {
                VStack {
                    ForEach(0 ..< 12) { _ in
                        NavigationLink(
                            destination: CentreDetailView(),
                            label: {
                                CentreContentView()
                            })
                    }
                }
            })
        }
        .navigationTitle("Centre")
        .onAppear(perform: {
            updateNavigationBar()
            _tabBarController?.tabBar.isHidden = false
        })
        .introspectTabBarController { (UITabBarController) in
            self._tabBarController = UITabBarController
        }
    }

    private func updateNavigationBar() {
        UINavigationBar.appearance().backgroundColor = UIColor(Color.white)
        UINavigationBar.appearance().tintColor = .white
        UINavigationBar.appearance().barTintColor = .white
        UINavigationBar.appearance().setBackgroundImage(nil, for: .default)
        UINavigationBar.appearance().shadowImage = nil
        UINavigationBar.appearance().titleTextAttributes = [NSAttributedString.Key.foregroundColor : UIColor.darkText]
    }
    
}

struct CentreViewPreview: PreviewProvider {
    static var previews: some View {
        NavigationView {
            CentreView()
        }
    }
}

struct CentreContentView: View {
    
    var body: some View {
        VStack(alignment: .leading) {
            
            HStack(alignment: .top, spacing: 14) {
                Image("arc")
                    .resizable()
                    .scaledToFill()
                    .frame(width: 80, height: 80)
                    .clipShape(Circle())
                VStack(alignment: .leading, spacing: 4) {
                    Text("Animal Rescue Centre")
                        .font(.system(size: 18, weight: .semibold, design: .default))
                        .foregroundColor(.darkText)
                    Text("Phnom Penh")
                        .font(.system(size: 14, weight: .regular, design: .default))
                        .foregroundColor(.darkText)
                    Text("A non-profit organization that works tirelessly to end suffering for dogs and cats on the streets of Cambodia.")
                        .fixedSize(horizontal: false, vertical: true)
                        .foregroundColor(.darkText)
                        .font(.system(size: 10, weight: .regular))
                        .padding(.bottom, 4)
                    
                    
//                    Button(action: {}, label: {
//                        HStack {
//                            Image(systemName: "phone.fill")
//                            Text("Contact us ")
//                        }
//                    })
//                    .padding(4)
//                    .foregroundColor(.darkText)
//                    .background(Color.primaryLight)
//                    .cornerRadius(6)
                }
                .frame(maxWidth: .infinity, alignment: .leading)
            }
            .padding()
            .frame(maxWidth: .infinity, alignment: .top)
            
            Divider()
                .background(Color.lightGrey)
                .padding(.trailing)
                .padding(.leading)
            
            HStack(spacing: 32) {
                Spacer()
                Button(action: { }) {
                    HStack {
                        Image(systemName: "heart")
                        Text("Donate")
                    }
                    .foregroundColor(.primaryColor)
                }
                .frame(width: 120, height: 32)
                .background(Color.lightText)
                .cornerRadius(6)
            }
            .padding(.leading)
            .padding(.trailing)
            .padding(.bottom)
        }
        .background(Color.white)
        .padding()
        .shadow(color: Color.black.opacity(0.04), radius: 8, x: 0, y: 3)
    }
    
}
