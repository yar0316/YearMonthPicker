/**
 * Copyright 2019 yar0316
 *
 * Permission is hereby granted, free of charge,
 * to any person obtaining a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.yar0316.yearmonthpicker

import android.content.Context
import android.view.LayoutInflater
import android.widget.NumberPicker
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.*

private var MIN_YEAR = 2000
private var MAX_YEAR = 2199
private val MONTHS = arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")

class MonthYearPickerView(mContext: Context): ConstraintLayout(mContext) {
    private var monthPicker: NumberPicker
    private var yearPicker: NumberPicker

    init {
        LayoutInflater.from(mContext).inflate(R.layout.fragment_month_year_dialog, this)

        // pickerの初期値は今月になるように
        val calendar = Calendar.getInstance()
        monthPicker = findViewById(R.id.monthPicker)
        yearPicker = findViewById(R.id.yearPicker)
        monthPicker.value = calendar.get(Calendar.MONTH)
        yearPicker.value = calendar.get(Calendar.YEAR)

        // 各Pickerの設定
        monthPicker.displayedValues = MONTHS
        monthPicker.minValue = 0
        monthPicker.maxValue = MONTHS.size - 1
        yearPicker.minValue = MIN_YEAR
        yearPicker.maxValue = MAX_YEAR
    }

    fun setYearMonth(year: Int, month: Int) {
        yearPicker.value = year
        monthPicker.value = month
    }

    /**
     * 選択された年と月の数値を返す
     * @return first: 年 second: 月
     */
    fun getYearMonth(): Pair<Int, Int>{
        return Pair(yearPicker.value, monthPicker.value + 1)
    }
}