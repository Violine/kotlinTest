package com.korovin.alexander.www.orcavspenguin.Adaptors

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.korovin.alexander.www.orcavspenguin.Model.Cell
import com.korovin.alexander.www.orcavspenguin.Model.GameProcess
import com.korovin.alexander.www.orcavspenguin.Model.Orca
import com.korovin.alexander.www.orcavspenguin.R
import org.jetbrains.anko.padding


class GamePadAdapter(private val context: Context, row: Int, column: Int, private val cellSize: Int
) : BaseAdapter() {

    val gameProcess: GameProcess = GameProcess(row, column)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val textView: ImageView
        if (convertView == null) {
            textView = ImageView(context, null, R.drawable.item_border)
//          textView.setImageResource(R.mipmap.orca)
            textView.adjustViewBounds = true
            textView.layoutParams = AbsListView.LayoutParams(cellSize - 17, cellSize - 17)
            textView.padding = 20
            textView.scaleType = ImageView.ScaleType.FIT_CENTER
        } else {
            textView = convertView as ImageView
        }
        val cell: Cell = getItem(position) as Cell
        if (cell.animal is Orca) textView.setImageResource(R.mipmap.orca)

        return textView

    }

    override fun getItem(position: Int): Any {
        return GameProcess.getCellToPosition(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()

    }

    override fun getCount(): Int {
        return GameProcess.getCellCounter()
    }
}