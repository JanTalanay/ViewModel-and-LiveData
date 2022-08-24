package com.example.viewmodelandlivedata.helper

class MainHelper {
    companion object{
        fun getMessageFee():String{
            return "Delivery Fee: + (Php) 45"
        }
        fun getMessageFree():String{
            return "Delivery Fee: + (Php) 0"
        }
        fun getAppleDesc():String{
            return "An apple is an edible fruit produced by an apple tree (Malus domestica). " +
                    "Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. " +
                    "The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today"
        }
        fun getApplePrice():Int{
            return 120
        }
    }
}