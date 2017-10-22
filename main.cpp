/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: ohiangel
 *
 * Created on October 18, 2017, 6:16 PM
 */

#include <cstdlib>
#include <iostream>

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    
    cout << "Welcome to Coors Banking System!" << endl;
    cout << "Please enter a number from the following options." << endl;
    int menuOption = 1;
    while(menuOption <=6 || menuOption >= 1)
    {
        cout << "1) View accounts." << endl;
        cout << "2) Transer money between accounts." << endl;
        cout << "3) Make deposit." << endl;
        cout << "4) Withdrawl from account." << endl;
        cout << "5) Create checkings or savings account." << endl;
        cout << "6) Delete accounts." << endl;
        int temp;
        cin >> temp;
        if((isdigit(temp)) && (temp <=6 || temp >= 1))
            menuOption = temp;
        else{
            cout << "Invalid option. Use numbers 1-6!";
            cin >> temp;
        }
        cout << endl << endl;
        cout << "Menu Option :" << menuOption << endl << endl;
    }
    
    

    return 0;
}

