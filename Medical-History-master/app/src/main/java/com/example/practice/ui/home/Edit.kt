package com.example.practice.ui.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.practice.R
import com.example.practice.Room.UserDatabase
import com.example.practice.hideKeyboard
import com.example.practice.models.User
import com.google.android.material.button.MaterialButton

class Edit : Fragment() {

    private val myPreference = "myPref"

    //keys for values entered in MedicationsFragment
    private val MED1_KEY = "KEY_MED1"
    private val MED2_KEY = "KEY_MED2"
    private val MED3_KEY = "KEY_MED3"
    private val MED4_KEY = "KEY_MED4"
    private val MED5_KEY = "KEY_MED5"
    private val MED6_KEY = "KEY_MED6"
    private val MED7_KEY = "KEY_MED7"
    private val MED8_KEY = "KEY_MED8"
    private val MED9_KEY = "KEY_MED9"
    private val MED10_KEY = "KEY_MED10"

    private lateinit var sharedPreferences: SharedPreferences

    private  val args by navArgs<EditArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.edit_layout,
            container, false)

        //EditText
        val dateEditET = view.findViewById<EditText>(R.id.enter_date)
        val weightEditET = view.findViewById<EditText>(R.id.enter_weight)
        val hourEditET = view.findViewById<EditText>(R.id.enter_hours)
        val colonEditET = view.findViewById<TextView>(R.id.enter_colon)
        val minutesEditET = view.findViewById<EditText>(R.id.enter_minutes)
        val bgEditET = view.findViewById<EditText>(R.id.enter_bg)
        val systolicEditET = view.findViewById<EditText>(R.id.enter_systolic)
        val slashEditET = view.findViewById<TextView>(R.id.enter_slash)
        val diastolicEditET = view.findViewById<EditText>(R.id.enter_diastolic)
        val med1EditET = view.findViewById<EditText>(R.id.enter_med1)
        val med2EditET = view.findViewById<EditText>(R.id.enter_med2)
        val med3EditET = view.findViewById<EditText>(R.id.enter_med3)
        val med4EditET = view.findViewById<EditText>(R.id.enter_med4)
        val med5EditET = view.findViewById<EditText>(R.id.enter_med5)
        val med6EditET = view.findViewById<EditText>(R.id.enter_med6)
        val med7EditET = view.findViewById<EditText>(R.id.enter_med7)
        val med8EditET = view.findViewById<EditText>(R.id.enter_med8)
        val med9EditET = view.findViewById<EditText>(R.id.enter_med9)
        val med10EditET = view.findViewById<EditText>(R.id.enter_med10)
        val commentEditET = view.findViewById<EditText>(R.id.enter_comment)

        //receives data from User.kt
        dateEditET.setText(args.currentUser.date_tv)
        weightEditET.setText(args.currentUser.weight_tv)
        hourEditET.setText(args.currentUser.hour_tv)
        colonEditET.setText(args.currentUser.colon_tv)
        minutesEditET.setText(args.currentUser.minutes_tv)
        bgEditET.setText(args.currentUser.bg_tv)
        systolicEditET.setText(args.currentUser.systolic_tv)
        slashEditET.setText(args.currentUser.slash_tv)
        diastolicEditET.setText(args.currentUser.diastolic_tv)
        med1EditET.setText(args.currentUser.med1_tv)
        med2EditET.setText(args.currentUser.med2_tv)
        med3EditET.setText(args.currentUser.med3_tv)
        med4EditET.setText(args.currentUser.med4_tv)
        med5EditET.setText(args.currentUser.med5_tv)
        med6EditET.setText(args.currentUser.med6_tv)
        med7EditET.setText(args.currentUser.med7_tv)
        med8EditET.setText(args.currentUser.med8_tv)
        med9EditET.setText(args.currentUser.med9_tv)
        med10EditET.setText(args.currentUser.med10_tv)
        commentEditET.setText(args.currentUser.comment_tv)

        //TextViews display meds which cannot be changed
        val med1UpdateTV = view.findViewById<TextView>(R.id.view_med1)
        val med2UpdateTV = view.findViewById<TextView>(R.id.view_med2)
        val med3UpdateTV = view.findViewById<TextView>(R.id.view_med3)
        val med4UpdateTV = view.findViewById<TextView>(R.id.view_med4)
        val med5UpdateTV = view.findViewById<TextView>(R.id.view_med5)
        val med6UpdateTV = view.findViewById<TextView>(R.id.view_med6)
        val med7UpdateTV = view.findViewById<TextView>(R.id.view_med7)
        val med8UpdateTV = view.findViewById<TextView>(R.id.view_med8)
        val med9UpdateTV = view.findViewById<TextView>(R.id.view_med9)
        val med10UpdateTV = view.findViewById<TextView>(R.id.view_med10)

        //navigates to MedicationsFragment
        med1UpdateTV!!.setOnClickListener {findNavController().navigate(R.id.action_editFragment_to_nav_medications)}
        med2UpdateTV!!.setOnClickListener {findNavController().navigate(R.id.action_editFragment_to_nav_medications)}
        med3UpdateTV!!.setOnClickListener {findNavController().navigate(R.id.action_editFragment_to_nav_medications)}
        med4UpdateTV!!.setOnClickListener {findNavController().navigate(R.id.action_editFragment_to_nav_medications)}
        med5UpdateTV!!.setOnClickListener {findNavController().navigate(R.id.action_editFragment_to_nav_medications)}
        med6UpdateTV!!.setOnClickListener {findNavController().navigate(R.id.action_editFragment_to_nav_medications)}
        med7UpdateTV!!.setOnClickListener {findNavController().navigate(R.id.action_editFragment_to_nav_medications)}
        med8UpdateTV!!.setOnClickListener {findNavController().navigate(R.id.action_editFragment_to_nav_medications)}
        med9UpdateTV!!.setOnClickListener {findNavController().navigate(R.id.action_editFragment_to_nav_medications)}
        med10UpdateTV!!.setOnClickListener {findNavController().navigate(R.id.action_editFragment_to_nav_medications)}

        sharedPreferences =
            requireActivity().getSharedPreferences(myPreference, Context.MODE_PRIVATE)

        //med#UpdateTV displays value of sharedpreference entered in MedicationsFragment
        med1UpdateTV.text = sharedPreferences.getString(MED1_KEY, "")
        med2UpdateTV.text = sharedPreferences.getString(MED2_KEY, "")
        med3UpdateTV.text = sharedPreferences.getString(MED3_KEY, "")
        med4UpdateTV.text = sharedPreferences.getString(MED4_KEY, "")
        med5UpdateTV.text = sharedPreferences.getString(MED5_KEY, "")
        med6UpdateTV.text = sharedPreferences.getString(MED6_KEY, "")
        med7UpdateTV.text = sharedPreferences.getString(MED7_KEY, "")
        med8UpdateTV.text = sharedPreferences.getString(MED8_KEY, "")
        med9UpdateTV.text = sharedPreferences.getString(MED9_KEY, "")
        med10UpdateTV.text = sharedPreferences.getString(MED10_KEY, "")

        //displays meds
        if (med1UpdateTV.text.isNotEmpty()) {med1UpdateTV.visibility = View.VISIBLE}
        if (med2UpdateTV.text.isNotEmpty()) {med2UpdateTV.visibility = View.VISIBLE}
        if (med3UpdateTV.text.isNotEmpty()) {med3UpdateTV.visibility = View.VISIBLE}
        if (med4UpdateTV.text.isNotEmpty()) {med4UpdateTV.visibility = View.VISIBLE}
        if (med5UpdateTV.text.isNotEmpty()) {med5UpdateTV.visibility = View.VISIBLE}
        if (med6UpdateTV.text.isNotEmpty()) {med6UpdateTV.visibility = View.VISIBLE}
        if (med7UpdateTV.text.isNotEmpty()) {med7UpdateTV.visibility = View.VISIBLE}
        if (med8UpdateTV.text.isNotEmpty()) {med8UpdateTV.visibility = View.VISIBLE}
        if (med9UpdateTV.text.isNotEmpty()) {med9UpdateTV.visibility = View.VISIBLE}
        if (med10UpdateTV.text.isNotEmpty()) {med10UpdateTV.visibility = View.VISIBLE}

        //displays empty edittext next to a med
        //if a med has been entered in MedicationsFragment, med is displayed in med#UpdateTV
        //and med#EditET becomes visible
        if (med1UpdateTV.text.isNotEmpty()) {med1EditET.visibility = View.VISIBLE}
        if (med2UpdateTV.text.isNotEmpty()) {med2EditET.visibility = View.VISIBLE}
        if (med3UpdateTV.text.isNotEmpty()) {med3EditET.visibility = View.VISIBLE}
        if (med4UpdateTV.text.isNotEmpty()) {med4EditET.visibility = View.VISIBLE}
        if (med5UpdateTV.text.isNotEmpty()) {med5EditET.visibility = View.VISIBLE}
        if (med6UpdateTV.text.isNotEmpty()) {med6EditET.visibility = View.VISIBLE}
        if (med7UpdateTV.text.isNotEmpty()) {med7EditET.visibility = View.VISIBLE}
        if (med8UpdateTV.text.isNotEmpty()) {med8EditET.visibility = View.VISIBLE}
        if (med9UpdateTV.text.isNotEmpty()) {med9EditET.visibility = View.VISIBLE}
        if (med10UpdateTV.text.isNotEmpty()) {med10EditET.visibility = View.VISIBLE}

        //updates item in database
        view.findViewById<MaterialButton>(R.id.EditButton)
            .setOnClickListener {
                val application = requireNotNull(this.activity).application

                val dataSource = UserDatabase.getInstance(application).userDao()

                val viewModelFactory = HomeViewModelFactory(dataSource, application)

                val mViewModel = ViewModelProvider(
                    this, viewModelFactory).get(HomeViewModel::class.java)
                val user = User(args.currentUser.stat_id,

                    dateEditET.text.toString(),
                    weightEditET.text.toString(),
                    hourEditET.text.toString(),
                    colonEditET.text.toString(),
                    minutesEditET.text.toString(),
                    bgEditET.text.toString(),
                    systolicEditET.text.toString(),
                    slashEditET.text.toString(),
                    diastolicEditET.text.toString(),
                    med1EditET.text.toString(),
                    med2EditET.text.toString(),
                    med3EditET.text.toString(),
                    med4EditET.text.toString(),
                    med5EditET.text.toString(),
                    med6EditET.text.toString(),
                    med7EditET.text.toString(),
                    med8EditET.text.toString(),
                    med9EditET.text.toString(),
                    med10EditET.text.toString(),
                    commentEditET.text.toString())

                mViewModel.upDateData(user)
                Toast.makeText(context?.applicationContext, "The database record has been updated.", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.editFragment_to_homeFragment)
            }

        //deletes item from database
        view.findViewById<MaterialButton>(R.id.DeleteButton)
            .setOnClickListener {
                val application = requireNotNull(this.activity).application

                val dataSource = UserDatabase.getInstance(application).userDao()

                val viewModelFactory = HomeViewModelFactory(dataSource, application)

                val mViewModel = ViewModelProvider(
                    this, viewModelFactory)
                    .get(HomeViewModel::class.java)
                val user = User(args.currentUser.stat_id,

                    dateEditET.text.toString(),
                    weightEditET.text.toString(),
                    hourEditET.text.toString(),
                    colonEditET.text.toString(),
                    minutesEditET.text.toString(),
                    bgEditET.text.toString(),
                    systolicEditET.text.toString(),
                    slashEditET.text.toString(),
                    diastolicEditET.text.toString(),
                    med1EditET.text.toString(),
                    med2EditET.text.toString(),
                    med3EditET.text.toString(),
                    med4EditET.text.toString(),
                    med5EditET.text.toString(),
                    med6EditET.text.toString(),
                    med7EditET.text.toString(),
                    med8EditET.text.toString(),
                    med9EditET.text.toString(),
                    med10EditET.text.toString(),
                    commentEditET.text.toString())

                mViewModel.deleteData(user)
                Toast.makeText(context?.applicationContext, "The record has been deleted from the database.", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.editFragment_to_homeFragment)
            }
        return view
    }

    //hides keyboard
    override fun onResume() {
        super.onResume()
        hideKeyboard()}
}