package com.example.practice.ui.home

import android.content.Context
import android.content.SharedPreferences
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.practice.R
import com.example.practice.Room.UserDatabase
import com.example.practice.hideKeyboard
import com.example.practice.models.User
import com.google.android.material.button.MaterialButton
import java.util.*

class Add : Fragment() {

    private var med1_textview: TextView? = null
    private var med2_textview: TextView? = null
    private var med3_textview: TextView? = null
    private var med4_textview: TextView? = null
    private var med5_textview: TextView? = null
    private var med6_textview: TextView? = null
    private var med7_textview: TextView? = null
    private var med8_textview: TextView? = null
    private var med9_textview: TextView? = null
    private var med10_textview: TextView? = null

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

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var sharedPreferences: SharedPreferences

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val view = inflater.inflate(R.layout.add_layout,
            container, false)
        val application = requireNotNull(this.activity).application

        val dataSource = UserDatabase.getInstance(application).userDao()

        val viewModelFactory = HomeViewModelFactory(dataSource, application)

        homeViewModel = ViewModelProvider(
            this, viewModelFactory)
            .get(HomeViewModel::class.java)

        val simpleDateFormat = SimpleDateFormat("MM/dd")
        val current: String = simpleDateFormat.format(Date())

        //EditText
        val add_date = view.findViewById<TextView>(R.id.enter_date)
        //date
        add_date.text = current
        val add_weight = view.findViewById<EditText>(R.id.enter_weight)
        val add_hour = view.findViewById<EditText>(R.id.enter_hours)
        val add_colon = view.findViewById<TextView>(R.id.enter_colon)
        val add_minutes = view.findViewById<EditText>(R.id.enter_minutes)
        val add_bg = view.findViewById<EditText>(R.id.enter_bg)
        val add_systolic = view.findViewById<EditText>(R.id.enter_systolic)
        val add_slash = view.findViewById<TextView>(R.id.enter_slash)
        val add_diastolic = view.findViewById<EditText>(R.id.enter_diastolic)
        val add_Med1 = view.findViewById<EditText>(R.id.enter_med1)
        val add_Med2 = view.findViewById<EditText>(R.id.enter_med2)
        val add_Med3 = view.findViewById<EditText>(R.id.enter_med3)
        val add_Med4 = view.findViewById<EditText>(R.id.enter_med4)
        val add_Med5 = view.findViewById<EditText>(R.id.enter_med5)
        val add_Med6 = view.findViewById<EditText>(R.id.enter_med6)
        val add_Med7 = view.findViewById<EditText>(R.id.enter_med7)
        val add_Med8 = view.findViewById<EditText>(R.id.enter_med8)
        val add_Med9 = view.findViewById<EditText>(R.id.enter_med9)
        val add_Med10 = view.findViewById<EditText>(R.id.enter_med10)
        val add_comment = view.findViewById<EditText>(R.id.enter_comment)

        //TextView
        med1_textview = view.findViewById(R.id.view_med1) as TextView
        med2_textview = view.findViewById(R.id.view_med2) as TextView
        med3_textview = view.findViewById(R.id.view_med3) as TextView
        med4_textview = view.findViewById(R.id.view_med4) as TextView
        med5_textview = view.findViewById(R.id.view_med5) as TextView
        med6_textview = view.findViewById(R.id.view_med6) as TextView
        med7_textview = view.findViewById(R.id.view_med7) as TextView
        med8_textview = view.findViewById(R.id.view_med8) as TextView
        med9_textview = view.findViewById(R.id.view_med9) as TextView
        med10_textview = view.findViewById(R.id.view_med10) as TextView

        //navigates to MedicationsFragment
        med1_textview!!.setOnClickListener {findNavController().navigate(R.id.action_addFragment_to_nav_medications)}
        med2_textview!!.setOnClickListener {findNavController().navigate(R.id.action_addFragment_to_nav_medications)}
        med3_textview!!.setOnClickListener {findNavController().navigate(R.id.action_addFragment_to_nav_medications)}
        med4_textview!!.setOnClickListener {findNavController().navigate(R.id.action_addFragment_to_nav_medications)}
        med5_textview!!.setOnClickListener {findNavController().navigate(R.id.action_addFragment_to_nav_medications)}
        med6_textview!!.setOnClickListener {findNavController().navigate(R.id.action_addFragment_to_nav_medications)}
        med7_textview!!.setOnClickListener {findNavController().navigate(R.id.action_addFragment_to_nav_medications)}
        med8_textview!!.setOnClickListener {findNavController().navigate(R.id.action_addFragment_to_nav_medications)}
        med9_textview!!.setOnClickListener {findNavController().navigate(R.id.action_addFragment_to_nav_medications)}
        med10_textview!!.setOnClickListener {findNavController().navigate(R.id.action_addFragment_to_nav_medications)}

        sharedPreferences =
            requireActivity().getSharedPreferences(myPreference, Context.MODE_PRIVATE)

        //med#textview displays value of sharedpreference entered in MedicationsFragment
        med1_textview!!.text = sharedPreferences.getString(MED1_KEY, "")
        med2_textview!!.text = sharedPreferences.getString(MED2_KEY, "")
        med3_textview!!.text = sharedPreferences.getString(MED3_KEY, "")
        med4_textview!!.text = sharedPreferences.getString(MED4_KEY, "")
        med5_textview!!.text = sharedPreferences.getString(MED5_KEY, "")
        med6_textview!!.text = sharedPreferences.getString(MED6_KEY, "")
        med7_textview!!.text = sharedPreferences.getString(MED7_KEY, "")
        med8_textview!!.text = sharedPreferences.getString(MED8_KEY, "")
        med9_textview!!.text = sharedPreferences.getString(MED9_KEY, "")
        med10_textview!!.text = sharedPreferences.getString(MED10_KEY, "")

        //displays meds in textview
        if (med1_textview!!.text.isNotEmpty()) {med1_textview!!.visibility = View.VISIBLE}
        if (med2_textview!!.text.isNotEmpty()) {med2_textview!!.visibility = View.VISIBLE}
        if (med3_textview!!.text.isNotEmpty()) {med3_textview!!.visibility = View.VISIBLE}
        if (med4_textview!!.text.isNotEmpty()) {med4_textview!!.visibility = View.VISIBLE}
        if (med5_textview!!.text.isNotEmpty()) {med5_textview!!.visibility = View.VISIBLE}
        if (med6_textview!!.text.isNotEmpty()) {med6_textview!!.visibility = View.VISIBLE}
        if (med7_textview!!.text.isNotEmpty()) {med7_textview!!.visibility = View.VISIBLE}
        if (med8_textview!!.text.isNotEmpty()) {med8_textview!!.visibility = View.VISIBLE}
        if (med9_textview!!.text.isNotEmpty()) {med9_textview!!.visibility = View.VISIBLE}
        if (med10_textview!!.text.isNotEmpty()) {med10_textview!!.visibility = View.VISIBLE}

        //puts a space in the add_Med# edittext when textview contains a med,
        // making it not empty
        if (med1_textview!!.text.isNotEmpty()) {add_Med1.setText(" ")}
        if (med2_textview!!.text.isNotEmpty()) {add_Med2.setText(" ")}
        if (med3_textview!!.text.isNotEmpty()) {add_Med3.setText(" ")}
        if (med4_textview!!.text.isNotEmpty()) {add_Med4.setText(" ")}
        if (med5_textview!!.text.isNotEmpty()) {add_Med5.setText(" ")}
        if (med6_textview!!.text.isNotEmpty()) {add_Med6.setText(" ")}
        if (med7_textview!!.text.isNotEmpty()) {add_Med7.setText(" ")}
        if (med8_textview!!.text.isNotEmpty()) {add_Med8.setText(" ")}
        if (med9_textview!!.text.isNotEmpty()) {add_Med9.setText(" ")}
        if (med10_textview!!.text.isNotEmpty()) {add_Med10.setText(" ")}

        //displays edittext associated with a med
        if (med1_textview!!.text.isNotEmpty()) {add_Med1!!.visibility = View.VISIBLE}
        if (med2_textview!!.text.isNotEmpty()) {add_Med2!!.visibility = View.VISIBLE}
        if (med3_textview!!.text.isNotEmpty()) {add_Med3!!.visibility = View.VISIBLE}
        if (med4_textview!!.text.isNotEmpty()) {add_Med4!!.visibility = View.VISIBLE}
        if (med5_textview!!.text.isNotEmpty()) {add_Med5!!.visibility = View.VISIBLE}
        if (med6_textview!!.text.isNotEmpty()) {add_Med6!!.visibility = View.VISIBLE}
        if (med7_textview!!.text.isNotEmpty()) {add_Med7!!.visibility = View.VISIBLE}
        if (med8_textview!!.text.isNotEmpty()) {add_Med8!!.visibility = View.VISIBLE}
        if (med9_textview!!.text.isNotEmpty()) {add_Med9!!.visibility = View.VISIBLE}
        if (med10_textview!!.text.isNotEmpty()) {add_Med10!!.visibility = View.VISIBLE}

        //inserts data in database
        view.findViewById<MaterialButton>(R.id.AddButton)
            .setOnClickListener {

                insertDataToDB(
                    add_date.text.toString(),
                    add_weight.text.toString(),
                    add_hour.text.toString(),
                    add_colon.text.toString(),
                    add_minutes.text.toString(),
                    add_bg.text.toString(),
                    add_systolic.text.toString(),
                    add_slash.text.toString(),
                    add_diastolic.text.toString(),
                    add_Med1.text.toString(),
                    add_Med2.text.toString(),
                    add_Med3.text.toString(),
                    add_Med4.text.toString(),
                    add_Med5.text.toString(),
                    add_Med6.text.toString(),
                    add_Med7.text.toString(),
                    add_Med8.text.toString(),
                    add_Med9.text.toString(),
                    add_Med10.text.toString(),
                    add_comment.editableText)
            }

        return view
    }

    private fun insertDataToDB(
        ADD_date: String,
        ADD_weight: String,
        ADD_hour: String,
        ADD_colon: String,
        ADD_minutes: String,
        ADD_bg: String,
        ADD_systolic: String,
        ADD_slash: String,
        ADD_diastolic: String,
        ADD_Med1: String,
        ADD_Med2: String,
        ADD_Med3: String,
        ADD_Med4: String,
        ADD_Med5: String,
        ADD_Med6: String,
        ADD_Med7: String,
        ADD_Med8: String,
        ADD_Med9: String,
        ADD_Med10: String,
        ADD_comment: Editable) {

        val context = activity?.applicationContext

        if (inputCheck(
                ADD_date,
                ADD_weight,
                ADD_hour,
                ADD_colon,
                ADD_minutes,
                ADD_bg,
                ADD_systolic,
                ADD_slash,
                ADD_diastolic,
                ADD_Med1,
                ADD_Med2,
                ADD_Med3,
                ADD_Med4,
                ADD_Med5,
                ADD_Med6,
                ADD_Med7,
                ADD_Med8,
                ADD_Med9,
                ADD_Med10,
                ADD_comment)){
            val user = User(0,
                ADD_date,
                ADD_weight,
                ADD_hour,
                ADD_colon,
                ADD_minutes,
                ADD_bg,
                ADD_systolic,
                ADD_slash,
                ADD_diastolic,
                ADD_Med1,
                ADD_Med2,
                ADD_Med3,
                ADD_Med4,
                ADD_Med5,
                ADD_Med6,
                ADD_Med7,
                ADD_Med8,
                ADD_Med9,
                ADD_Med10,
                ADD_comment.toString())
            homeViewModel.addUser(user)
            Toast.makeText(context,"Your stats have been added to the database.", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.addFragment_to_homeFragment)
        }
    }

    private fun inputCheck(
        date_add: String,
        weight_add: String,
        hour_add: String,
        colon_add: String,
        minutes_add: String,
        bg_add: String,
        systolic_add: String,
        slash_add: String,
        diastolic_add: String,
        Med1_add: String,
        Med2_add: String,
        Med3_add: String,
        Med4_add: String,
        Med5_add: String,
        Med6_add: String,
        Med7_add: String,
        Med8_add: String,
        Med9_add: String,
        Med10_add: String,
        comment_add: Editable

    ):Boolean{
        return !(TextUtils.isEmpty(date_add)
                && TextUtils.isEmpty(weight_add)
                && TextUtils.isEmpty(hour_add)
                && TextUtils.isEmpty(colon_add)
                && TextUtils.isEmpty(minutes_add)
                && TextUtils.isEmpty(bg_add)
                && TextUtils.isEmpty(systolic_add)
                && TextUtils.isEmpty(slash_add)
                && TextUtils.isEmpty(diastolic_add)
                && TextUtils.isEmpty(Med1_add)
                && TextUtils.isEmpty(Med2_add)
                && TextUtils.isEmpty(Med3_add)
                && TextUtils.isEmpty(Med4_add)
                && TextUtils.isEmpty(Med5_add)
                && TextUtils.isEmpty(Med6_add)
                && TextUtils.isEmpty(Med7_add)
                && TextUtils.isEmpty(Med8_add)
                && TextUtils.isEmpty(Med9_add)
                && TextUtils.isEmpty(Med10_add)
                && comment_add.isEmpty())
    }

    //hides keyboard
    override fun onResume() {
        super.onResume()
        hideKeyboard()}
}