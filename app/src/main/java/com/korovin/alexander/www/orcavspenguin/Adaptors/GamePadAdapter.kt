package com.korovin.alexander.www.orcavspenguin.Adaptors

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.korovin.alexander.www.orcavspenguin.Model.Cell
import com.korovin.alexander.www.orcavspenguin.Model.GameProcess
import com.korovin.alexander.www.orcavspenguin.Model.Orca
import com.korovin.alexander.www.orcavspenguin.Model.Penguin
import com.korovin.alexander.www.orcavspenguin.R
import org.jetbrains.anko.padding


class GamePadAdapter(private val context: Context, row: Int, column: Int, private val cellSize: Int, val gameProcess: GameProcess = GameProcess(row, column)
) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView: ImageView
        if (convertView == null) {
            imageView = ImageView(context, null, R.drawable.item_border)
            imageView.adjustViewBounds = true
            imageView.layoutParams = AbsListView.LayoutParams(cellSize - 10, cellSize - 10)
            imageView.padding = 20
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER
        } else {
            imageView = convertView as ImageView
        }
        val cell: Cell = getItem(position) as Cell
        if (cell.animal is Orca) imageView.setImageResource(R.mipmap.orca)
        if (cell.animal is Penguin) imageView.setImageResource(R.mipmap.tux)


        return imageView

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