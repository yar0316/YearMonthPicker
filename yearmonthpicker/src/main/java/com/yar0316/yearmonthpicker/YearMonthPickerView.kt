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