package com.ninthsemester.recyclerviewanimations

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by sahil-mac on 28/03/18.
 */
class MyAdapter(private val string: String) : RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    private val items: MutableList<String> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item, parent, false)
                    .run {
                        ViewHolder(this)
                    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    private fun uniqueString(base: String) = "$base ${(Math.random() * 1000).toInt()}"

    fun appendItem(newString: String) =
            items.add(uniqueString(newString)).also {
                notifyItemInserted(itemCount - 1)
            }

    inner class ViewHolder(
            itemView: View,
            private val textView : TextView = itemView.findViewById(android.R.id.text1),
            upButton : View = itemView.findViewById(R.id.up),
            downButton : View = itemView.findViewById(R.id.down),
            addButton : View = itemView.findViewById(R.id.add),
            removeButton : View = itemView.findViewById(R.id.remove)
    ) : RecyclerView.ViewHolder(itemView) {


        init {
            addButton.setOnClickListener(insert())
            removeButton.setOnClickListener(remove())
            upButton.setOnClickListener(moveUp())
            downButton.setOnClickListener(moveDown())
        }


        private fun insert() : (View) -> Unit = {

            layoutPosition.also { currentPosition ->
                items.add(currentPosition, uniqueString(string))
                notifyItemInserted(currentPosition)
            }
        }


        private fun remove() : (View) -> Unit = {

            layoutPosition.also { currentPosition ->
                items.removeAt(currentPosition)
                notifyItemRemoved(currentPosition)
            }

        }

        private fun moveUp(): (View) -> Unit = {
            layoutPosition.takeIf { it > 0 } ?. also { currentPosition ->
                items.removeAt(currentPosition).also {
                    items.add(currentPosition - 1, it)
                }
                notifyItemMoved(currentPosition, currentPosition - 1)
            }
        }

        private fun moveDown(): (View) -> Unit = {
            layoutPosition.takeIf { it < items.size - 1 } ?.also { currentPosition ->
                items.removeAt(currentPosition).also {
                    items.add(currentPosition + 1, it)
                }
                notifyItemMoved(currentPosition, currentPosition + 1)
            }
        }

        fun bind(text : String) {
            textView.text = text
        }
    }
}