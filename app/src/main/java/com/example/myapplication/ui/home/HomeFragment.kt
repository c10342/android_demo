package com.example.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val homeViewModel =
//                ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
//        获取控件
        val recyclerView = root.findViewById<RecyclerView>(R.id.fragment_home_recycler_view)
//        设置布局模式-线性布局
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = StudyAdapter()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //    inner->内部类
    inner class StudyAdapter : RecyclerView.Adapter<StudyAdapter.StudyViewHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): StudyAdapter.StudyViewHolder {
            val view =
                LayoutInflater.from(context).inflate(R.layout.item_fragment_study, parent, false)
            return StudyViewHolder(view)
        }


        override fun getItemCount(): Int {
            return 6
        }

        override fun onBindViewHolder(holder: StudyAdapter.StudyViewHolder, position: Int) {
            val title = holder.itemView.findViewById<TextView>(R.id.study_item_title)
            title.text = "${position}移动端架构体系课"
        }

        inner class StudyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        }

    }
}


