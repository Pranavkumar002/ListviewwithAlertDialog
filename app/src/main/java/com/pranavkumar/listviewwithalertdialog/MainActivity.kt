package com.pranavkumar.listviewwithalertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.pranavkumar.listviewwithalertdialog.databinding.ActivityMainBinding
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: ArrayAdapter<String>
    var arraylist = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arraylist)
        binding.lv.adapter = adapter



        binding.fabAdd.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setCancelable(false)
                setTitle(resources.getString(R.string.add_random_name))
                setMessage(resources.getString(R.string.select))
                setNeutralButton(resources.getString(R.string.three)) { _, _ ->
                    var show = random(3)
                    arraylist.add(show)
                    adapter.notifyDataSetChanged()
                }
                setPositiveButton(resources.getString(R.string.five)) { _, _ ->
                    var show = random(5)
                    arraylist.add(show)
                    adapter.notifyDataSetChanged()
                }
                setNegativeButton(resources.getString(R.string.four)) { _, _ ->
                    var show = random(4)
                    arraylist.add(show)
                    adapter.notifyDataSetChanged()
                }
            }.show()
        }


        binding.lv.setOnItemClickListener { _, _, position, _ ->
            AlertDialog.Builder(this).apply {
                setCancelable(false)
                setTitle(resources.getString(R.string.add_or_update))
                setNeutralButton(resources.getString(R.string.delete)) { _, _ ->
                    arraylist.removeAt(position)
                    adapter.notifyDataSetChanged()
                }
                setPositiveButton(resources.getString(R.string.add2)) { _, _ ->
                    var show = random(2)
                    arraylist[position] += show
                    adapter.notifyDataSetChanged()
                }
                setNegativeButton(resources.getString(R.string.add)) { _, _ ->
                    var show = random(1)
                    arraylist[position] += show
                    adapter.notifyDataSetChanged()
                }
            }.show()
        }
    }
}



fun random(random:Int):String{
    var string = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    var show=""
    for (x in 1..random)
    {
        show+=string.random().toString()
    }
    return show
}