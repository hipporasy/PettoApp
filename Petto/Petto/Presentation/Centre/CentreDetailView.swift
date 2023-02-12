//
//  CentreDetailView.swift
//  Petto
//
//  Created by Marasy Phi on 1/4/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct CentreDetailView: View {
    @Environment(\.presentationMode) var presentedMode: Binding<PresentationMode>
    var leadingButton: some View {
        Button(action: {
            presentedMode.wrappedValue.dismiss()
        }) {
            Image(systemName: "arrow.left")
                .foregroundColor(.darkText)
        }
    }
    
    @State private var _selectedPetType: Pet.PetType = .dogs
    
    var body: some View {
        VStack {
            ScrollView {
                VStack(alignment: .leading) {
                    Image("arc")
                        .resizable()
                        .scaledToFill()
                        .frame(maxWidth: .infinity)
                
                    VStack(alignment: .leading) {
                        Text("Animal Rescue Centre")
                            .font(.system(size: 18, weight: .semibold, design: .default))
                            .foregroundColor(.darkText)
                        Divider()
                        HStack {
                            Image(systemName: "location.fill")
                            Text("Phnom Penh")
                                .font(.system(size: 14, weight: .regular, design: .default))
                                .foregroundColor(.darkText)
                            Spacer()
                        }
                        Spacer()
                        Text("A non-profit organization that works tirelessly to end suffering for dogs and cats on the streets of Cambodia.")
                            .fixedSize(horizontal: false, vertical: true)
                            .foregroundColor(.darkText)
                            .font(.system(size: 14, weight: .regular))
                            .padding(.bottom, 4)
                    }
                    .padding(.leading)
                    .padding(.trailing)
                    Divider()
                        .padding()
                    PetTypeView(selectedPetType: $_selectedPetType)
                    ForEach(_selectedPetType.pets) { eachPet in
                        PetRow(pet: eachPet)
                    }
                }
            }
        }
        .introspectTabBarController { (UITabBarController) in
            UITabBarController.tabBar.isHidden = true
        }
        .navigationBarItems(leading: leadingButton)
        .navigationBarTitleDisplayMode(.inline)
        .navigationBarBackButtonHidden(true)

    }
    
}

struct PetRow: View {
    let pet: Pet
    var body: some View {
        HStack {
            Image(pet.images.first!)
                .resizable()
                .scaledToFill()
                .frame(width: 120, height: 120, alignment: .center)
                .clipShape(RoundedRectangle(cornerRadius: 8))
                .shadow(color: Color.black.opacity(0.04), radius: 8, x: 0, y: 3)
            VStack(alignment: .leading) {
                Text(pet.name)
                    .font(.system(size: 18, weight: .medium))
                Text(pet.breed.description)
                    .font(.system(size: 18, weight: .regular))
                HStack {
                    Text(pet.displayType)
                        .frame(width: 70, height: 22)
                        .font(.system(size: 12, weight: .medium))
                        .foregroundColor(pet.isAdult ? .primaryYellow : .primaryColor)
                        .background(pet.isAdult ? Color.secondaryYellow : Color.primaryLight)
                        .cornerRadius(10)
                    Spacer()
                    Image(pet.gender.rawValue)
                        .foregroundColor(pet.isAdult ? Color.primaryYellow : Color.primaryColor)
                }
            }
            .padding()
            Spacer()
        }
        .padding()
        .frame(maxWidth: .infinity)
        .frame(height: 120)
        .background(Color.white)
        .clipShape(RoundedRectangle(cornerRadius: 8))
        .padding()
        .shadow(color: Color.black.opacity(0.04),
                radius: 8, x: 0, y: 3)
        
    }
    
}

struct CentreDetailViewPreview: PreviewProvider {
    
    static var previews: some View {
        NavigationView {
            CentreDetailView()
        }
    }
    
}
