package com.yar0316.yearmonthpicker.util

/**
 * Kotlinのカスタムピッカーダイアログ
 * 表示するのは年月のみ選択のPicker
 * {@link MonthYearPickerView}とセットで使用
 * @author yar0316
 */
import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import java.util.*
import java.util.Calendar.MONTH
import java.util.Calendar.YEAR

const val TEXT_DEFAULT_POSITIVE = "OK"
const val TEXT_DEFAULT_NEGATIVE = "Cancel"

class MonthYearPickerDialog(
    mContext: Context,
    pickerTitle: String,
    initialYear: Int,
    initialMonth: Int
):AlertDialog(mContext) {
    private var mPickerView: MonthYearPickerView = MonthYearPickerView(mContext)
    private var mBuilder: Builder

    init {
        mPickerView.setYearMonth(initialYear, initialMonth)
        mBuilder = Builder(mContext).setView(mPickerView)
            .setTitle(pickerTitle)
    }

    /**
     * 年月の初期値が渡されなければとりあえず今月
     */
    constructor(mContext: Context, title: String) : this(
        mContext,
        title,
        Calendar.getInstance().get(YEAR),
        Calendar.getInstance().get(MONTH)
    )

    override fun show() {
        mBuilder.show()
    }

    /**
     * OKボタンのリスナー追加
     * 忘れるとOKボタンが出てこないので注意
     * @param listener ボタンクリック時のコールバック
     */
    fun setPositiveButton(listener: DialogInterface.OnClickListener) {
        mBuilder.setPositiveButton(TEXT_DEFAULT_POSITIVE, listener)
    }

    /**
     * ボタンのテキストも決めたい時に使用（valuesに定義している値のリソースIDを渡す）
     * @param textId ボタンテキストのリソースID
     * @param listener リスナー
     */
    fun setPositiveButton(textId: Int, listener: DialogInterface.OnClickListener){
        mBuilder.setPositiveButton(textId, listener)
    }

    /**
     * ボタンのテキストも決めたい時に使用（まんま文字列を渡す）
     * @param text ボタンのテキスト
     * @param listener リスナー
     */
    fun setPositiveButton(text: String, listener: DialogInterface.OnClickListener){
        mBuilder.setPositiveButton(text, listener)
    }

    /**
     * キャンセルボタンのリスナー追加
     * 使わなかった場合ボタンが出てこない
     * @param listener ボタンクリック時のコールバック
     */
    fun setNegativeButton(listener: DialogInterface.OnClickListener){
        mBuilder.setNegativeButton(TEXT_DEFAULT_NEGATIVE, listener)
    }

    /**
     * ボタンのテキストも決めたい時に使用（valuesに定義している値のリソースIDを渡す）
     * @param textId ボタンテキストのリソースID
     * @param listener リスナー
     */
    fun setNegativeButton(textId: Int , listener: DialogInterface.OnClickListener){
        mBuilder.setNegativeButton(textId, listener)
    }

    /**
     * ボタンのテキストも決めたい時に使用（まんま文字列を渡す）
     * @param text ボタンのテキスト
     * @param listener リスナー
     */
    fun setNegativeButton(text: String, listener: DialogInterface.OnClickListener){
        mBuilder.setNegativeButton(text, listener)
    }

    /**
     * ダイアログで使用してるViewを返す
     * 閉じる時に選択されたデータを取得するとなると、私の能力ではこれないと書けなかった
     */
    fun getPickerView(): MonthYearPickerView{
        return mPickerView
    }
}