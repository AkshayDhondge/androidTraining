package com.example.firstandroidapp.activities.ui.gallery

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstandroidapp.R
import com.example.firstandroidapp.activities.Adapters.HobbiesAdapter
import com.example.firstandroidapp.activities.Model.Supplier


class GalleryFragment : Fragment() {

    private lateinit var galleryView: View
    private lateinit var recyclerView: RecyclerView

    @SuppressLint("LongLogTag")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryView =  inflater.inflate(R.layout.fragment_gallery, container, false)

        Log.d("This is fragment life cycle example", "onCreateView");

        recyclerView = galleryView.findViewById(R.id.recyclerView)

        val layoutManger = LinearLayoutManager(activity)
        layoutManger.orientation = LinearLayoutManager.VERTICAL

        recyclerView.layoutManager = layoutManger

        val adapter = activity?.let { HobbiesAdapter(it, Supplier.hobbies) }
        recyclerView.adapter = adapter

        return  galleryView
    }



    /*  Fragment life cycle methods to understand the life cycle of Fragment   */
    @SuppressLint("LongLogTag")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("This is fragment life cycle example", "onActivityCreated");
    }


    @SuppressLint("LongLogTag")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view!!, savedInstanceState)
        Log.d("This is fragment life cycle example", "onViewCreated");

    }

    @SuppressLint("LongLogTag")
    override fun onAttach(activity: Activity) {
        super.onAttach(activity!!)
        Log.d("This is fragment life cycle example", "onAttach");
    }

    @SuppressLint("LongLogTag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("This is fragment life cycle example", "onCreate");
    }

    @SuppressLint("LongLogTag")
    override fun onDestroy() {
        super.onDestroy()
        Log.d("This is fragment life cycle example", "onDestroy");
    }

    @SuppressLint("LongLogTag")
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("This is fragment life cycle example", "onDestroyView");
    }

    @SuppressLint("LongLogTag")
    override fun onDetach() {
        super.onDetach()
        Log.d("This is fragment life cycle example", "onDetach");
    }

    @SuppressLint("LongLogTag")
    override fun onPause() {
        super.onPause()
        Log.d("This is fragment life cycle example", "onPause");
    }

    @SuppressLint("LongLogTag")
    override fun onResume() {
        super.onResume()
        Log.d("This is fragment life cycle example", "onResume");
    }

    @SuppressLint("LongLogTag")
    override fun onStart() {
        super.onStart()
        Log.d("This is fragment life cycle example", "onStart");
    }

    @SuppressLint("LongLogTag")
    override fun onStop() {
        super.onStop()
        Log.d("This is fragment life cycle example", "onStop");
    }
}
