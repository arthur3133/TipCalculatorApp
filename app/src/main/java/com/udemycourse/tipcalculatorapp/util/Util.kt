package com.udemycourse.tipcalculatorapp.util

fun calculateTipAmount(totalBill: Double, tipPercentage: Int): Double {
    return if (totalBill > 1 && totalBill.toString().isNotEmpty())
        (totalBill * tipPercentage) / 100
    else
        0.0
}

fun calculateTotalPerPersonAmount(totalBill: Double, tipAmount: Double, splitBy: Int): Double {
    return (totalBill + tipAmount) / splitBy
}