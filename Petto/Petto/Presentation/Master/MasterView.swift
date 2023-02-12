//
//  MasterView.swift
//  PetAdoption
//
//  Created by Marasy Phi on 23/1/21.
//

import SwiftUI

struct MasterView: View {
    
    @State var selectedTabBarType: TabBarType = .home
    
    enum TabBarType: String, Identifiable, CaseIterable {
        
        case home, centre, profile
        
        var image: String {
            "ic.\(rawValue)"
        }
        
        var id: String {
            rawValue.capitalized
        }
        
        
    }
    
    var body: some View {
        
        TabView {
            NavigationView {
                HomeView()
            }
            .tabItem {
                Image(TabBarType.home.image)
                Text(TabBarType.home.rawValue.capitalized)
            }
            NavigationView {
                CentreView()
            }
            .tabItem {
                Image(TabBarType.centre.image)
                Text(TabBarType.centre.rawValue.capitalized)
            }
            
            NavigationView {
                ProfileView()
            }
            .tabItem {
                Image(TabBarType.profile.image)
                Text(TabBarType.profile.rawValue.capitalized)
            }
        }
        .onAppear {
            UITabBar.appearance().barTintColor = .white
        }
        .accentColor(Color.primaryDark)
        
    }
    
}


struct MasterViewPreview: PreviewProvider {
    
    static var previews: some View {
        MasterView()
    }
    
}
