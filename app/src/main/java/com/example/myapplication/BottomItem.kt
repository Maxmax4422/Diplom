package com.example.myapplication

 sealed class BottomItem ( val title:String, val iconId: Int, val route:String){
     object HomeScreen: BottomItem("Главная", R.drawable.home_2, "Главная" )
     object SecondScreen: BottomItem("Обращение", R.drawable.qwerty_2, "Обращение" )
     object ThreeScreen: BottomItem("О программе", R.drawable.about_programm_2, "О программе" )
}