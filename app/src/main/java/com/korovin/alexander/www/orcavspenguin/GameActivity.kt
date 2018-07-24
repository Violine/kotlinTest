package com.korovin.alexander.www.orcavspenguin

import android.content.Context
import android.graphics.Point
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.*
import android.widget.AdapterView
import com.korovin.alexander.www.orcavspenguin.Adaptors.GamePadAdapter
import com.korovin.alexander.www.orcavspenguin.Model.Cell
import com.korovin.alexander.www.orcavspenguin.Model.GameProcess

import kotlinx.android.synthetic.main.activity_game.*
import org.jetbrains.anko.toast

class GameActivity : AppCompatActivity() {
    private val tableRow: Int = 5
    private val tableColumn: Int = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        initUI()
        initGrid(this, tableRow, tableColumn)

    }

    private fun initUI() {
        setSupportActionBar(toolbar)

        new_game_button.setOnClickListener {
            initGrid(this, tableRow, tableColumn)
        }
    }

    private fun initGrid(context: Context, rows: Int, columns: Int) {
        val cellWidth = getDisplaySize() / columns
        game_pad.numColumns = columns
        game_pad.columnWidth = cellWidth
        game_pad.adapter = GamePadAdapter(context, rows, columns, cellWidth)
        game_pad.onItemClickListener = AdapterView.OnItemClickListener { _, _, _, _ ->
            GameProcess.lifeCycle()
            // тут нужно обновлять список
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_game, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getDisplaySize(): Int {
        val display: Display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size.x
    }
}
