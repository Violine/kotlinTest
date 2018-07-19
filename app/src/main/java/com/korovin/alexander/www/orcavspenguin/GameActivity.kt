package com.korovin.alexander.www.orcavspenguin

import android.media.Image
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import com.korovin.alexander.www.orcavspenguin.Model.Orca

import kotlinx.android.synthetic.main.activity_game.*
import org.jetbrains.anko.tableLayout
import org.jetbrains.anko.toast

class GameActivity : AppCompatActivity() {
    private val tableRow: Int = 15
    private val tableColumn: Int = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        initUI()
        initGrid(tableRow, tableColumn)

    }

    private fun initUI() {
        setSupportActionBar(toolbar)
        table_layout.setOnClickListener({
            toast("Такт игры")
            //такт игры
        })
        new_game_button.setOnClickListener({
            toast("Hello")
            // тут будем сбрасывать поле
        })
    }

    private fun initGrid(rows: Int, columns: Int) {
        for (i in 0 until rows) {
            val row = TableRow(this)
            row.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

            for (j in 0 until columns) {
                val button = Button(this)
                button.apply {
                    layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT)
                    text = "R $i C $j"
                }
                row.addView(button)
            }
            table_layout.addView(row)
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
}
