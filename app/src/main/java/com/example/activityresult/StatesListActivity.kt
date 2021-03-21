              package com.example.activityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AbsListView
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class StatesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listView = ListView(this)
        setContentView(listView)
        val arrayStates = resources.getStringArray(R.array.states)
        val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, arrayStates)
        listView.adapter = listAdapter
        listView.choiceMode = AbsListView.CHOICE_MODE_SINGLE

        val state = intent.getStringExtra(EXTRA_STATE)
        if (state != null){
         val position = arrayStates.indexOf(state)
         listView.setItemChecked(position, true)
        }

        //para tratar o evento de clique nos itens da ListView e sabermos qual foi o Estado
        //selecionado, devemos chamar o método setOnItemClickListener
        listView.setOnItemClickListener { ListView, view, position, _ ->
            val result = arrayStates [position]
            val it = Intent() //objeto intent para devolver dados para a tela anterior
            it.putExtra(EXTRA_RESULT, result) //add parametro com o nome do Estado
            setResult(Activity.RESULT_OK,it) //chama o método setResult
            finish() //encerra a activity
        }
    }

    companion object {
        const val EXTRA_STATE = "estado"
        const val EXTRA_RESULT = "resultado"
    }

}