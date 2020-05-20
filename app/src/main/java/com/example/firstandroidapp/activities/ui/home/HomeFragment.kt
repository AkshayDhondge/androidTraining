package com.example.firstandroidapp.activities.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.firstandroidapp.R


class HomeFragment : Fragment() {
    private lateinit var homeButton: Button
    private lateinit var showDialog: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var malaRadio: RadioButton
    private lateinit var femaleRadio: RadioButton
    private lateinit var checkBox1: CheckBox
    private var isProgress: Boolean? = true

    private lateinit var homeFragmentView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeFragmentView = inflater.inflate(R.layout.fragment_home, container, false)

        homeButton = homeFragmentView.findViewById(R.id.btnHome)
        progressBar = homeFragmentView.findViewById(R.id.progressBar)
        malaRadio = homeFragmentView.findViewById(R.id.radioMale)
        femaleRadio = homeFragmentView.findViewById(R.id.radioFemale)
        showDialog = homeFragmentView.findViewById(R.id.btnShowDialog)
        checkBox1 = homeFragmentView.findViewById(R.id.checkBox)

        homeButton.setOnClickListener {
            val toast: Toast =
                Toast.makeText(activity, "Its Home screen", Toast.LENGTH_SHORT)
            toast.show()
            if (isProgress == true) {
                progressBar.isVisible = false
                isProgress = !isProgress!!
            } else {
                progressBar.isVisible = true
                isProgress = !isProgress!!
            }

        }

        malaRadio.setOnClickListener {
            femaleRadio.isChecked = false
            malaRadio.isChecked = true

        }

        femaleRadio.setOnClickListener {
            femaleRadio.isChecked = true
            malaRadio.isChecked = false

        }

        checkBox1.setOnClickListener {
            if (checkBox1.isChecked) {
                checkBox1.text = "Checked"
            } else {
                checkBox1.text = "unchecked"
            }

        }


        showDialog.setOnClickListener {
            val builder = AlertDialog.Builder(activity)
            builder.setTitle("Test")
            builder.setMessage("Testing")
            builder.setPositiveButton("Yes") { _, _ ->
                Toast.makeText(activity, "clicked yes", Toast.LENGTH_LONG).show()
            }
            builder.setNeutralButton("Cancel") { _, _ ->
                Toast.makeText(activity, "clicked cancel\n operation cancel", Toast.LENGTH_LONG)
                    .show()
            }
            builder.setNegativeButton("No") { _, _ ->
                Toast.makeText(activity, "clicked No", Toast.LENGTH_LONG).show()
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }

        return homeFragmentView

    }


}
