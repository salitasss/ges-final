package com.example.practice.ui.medications

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.practice.R
import com.example.practice.hideKeyboard

class Medications : Fragment() {

    private lateinit var medicationsViewModel: MedicationsViewModel

    //TextView prevents user from changing medication
    private var med1TV: TextView? = null
    private var med2TV: TextView? = null
    private var med3TV: TextView? = null
    private var med4TV: TextView? = null
    private var med5TV: TextView? = null
    private var med6TV: TextView? = null
    private var med7TV: TextView? = null
    private var med8TV: TextView? = null
    private var med9TV: TextView? = null
    private var med10TV: TextView? = null

    //EditText
    private var med1ET: EditText? = null
    private var med2ET: EditText? = null
    private var med3ET: EditText? = null
    private var med4ET: EditText? = null
    private var med5ET: EditText? = null
    private var med6ET: EditText? = null
    private var med7ET: EditText? = null
    private var med8ET: EditText? = null
    private var med9ET: EditText? = null
    private var med10ET: EditText? = null
    private var quan1_et: EditText? = null
    private var quan2_et: EditText? = null
    private var quan3_et: EditText? = null
    private var quan4_et: EditText? = null
    private var quan5_et: EditText? = null
    private var quan6_et: EditText? = null
    private var quan7_et: EditText? = null
    private var quan8_et: EditText? = null
    private var quan9_et: EditText? = null
    private var quan10_et: EditText? = null

    private val myPreference = "myPref"

    //persists user input
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
    private val QUANmed1_KEY = "KEY_QUAN1"
    private val QUANmed2_KEY = "KEY_QUAN2"
    private val QUANmed3_KEY = "KEY_QUAN3"
    private val QUANmed4_KEY = "KEY_QUAN4"
    private val QUANmed5_KEY = "KEY_QUAN5"
    private val QUANmed6_KEY = "KEY_QUAN6"
    private val QUANmed7_KEY = "KEY_QUAN7"
    private val QUANmed8_KEY = "KEY_QUAN8"
    private val QUANmed9_KEY = "KEY_QUAN9"
    private val QUANmed10_KEY = "KEY_QUAN10"

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?,

                              ): View? {
        medicationsViewModel =
            ViewModelProvider(this).get(MedicationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_medications, container, false)

        //EditText
        med1ET = root.findViewById(R.id.med1_edittext)
        med2ET = root.findViewById(R.id.med2_edittext)
        med3ET = root.findViewById(R.id.med3_edittext)
        med4ET = root.findViewById(R.id.med4_edittext)
        med5ET = root.findViewById(R.id.med5_edittext)
        med6ET = root.findViewById(R.id.med6_edittext)
        med7ET = root.findViewById(R.id.med7_edittext)
        med8ET = root.findViewById(R.id.med8_edittext)
        med9ET = root.findViewById(R.id.med9_edittext)
        med10ET = root.findViewById(R.id.med10_edittext)
        quan1_et = root.findViewById(R.id.quan1_edittext)
        quan2_et = root.findViewById(R.id.quan2_edittext)
        quan3_et = root.findViewById(R.id.quan3_edittext)
        quan4_et = root.findViewById(R.id.quan4_edittext)
        quan5_et = root.findViewById(R.id.quan5_edittext)
        quan6_et = root.findViewById(R.id.quan6_edittext)
        quan7_et = root.findViewById(R.id.quan7_edittext)
        quan8_et = root.findViewById(R.id.quan8_edittext)
        quan9_et = root.findViewById(R.id.quan9_edittext)
        quan10_et = root.findViewById(R.id.quan10_edittext)

        //associates textwatcher with med#ET
        med1ET!!.addTextChangedListener(TextWatcher1)
        med2ET!!.addTextChangedListener(TextWatcher2)
        med3ET!!.addTextChangedListener(TextWatcher3)
        med4ET!!.addTextChangedListener(TextWatcher4)
        med5ET!!.addTextChangedListener(TextWatcher5)
        med6ET!!.addTextChangedListener(TextWatcher6)
        med7ET!!.addTextChangedListener(TextWatcher7)
        med8ET!!.addTextChangedListener(TextWatcher8)
        med9ET!!.addTextChangedListener(TextWatcher9)
        med10ET!!.addTextChangedListener(TextWatcher10)
        quan1_et!!.addTextChangedListener(TextWatcher11)
        quan2_et!!.addTextChangedListener(TextWatcher12)
        quan3_et!!.addTextChangedListener(TextWatcher13)
        quan4_et!!.addTextChangedListener(TextWatcher14)
        quan5_et!!.addTextChangedListener(TextWatcher15)
        quan6_et!!.addTextChangedListener(TextWatcher16)
        quan7_et!!.addTextChangedListener(TextWatcher17)
        quan8_et!!.addTextChangedListener(TextWatcher18)
        quan9_et!!.addTextChangedListener(TextWatcher19)
        quan10_et!!.addTextChangedListener(TextWatcher20)

        sharedPreferences =
            requireActivity().getSharedPreferences(myPreference, Context.MODE_PRIVATE)

        //assigns value to key
        med1ET!!.setText(sharedPreferences.getString(MED1_KEY, ""))
        med2ET!!.setText(sharedPreferences.getString(MED2_KEY, ""))
        med3ET!!.setText(sharedPreferences.getString(MED3_KEY, ""))
        med4ET!!.setText(sharedPreferences.getString(MED4_KEY, ""))
        med5ET!!.setText(sharedPreferences.getString(MED5_KEY, ""))
        med6ET!!.setText(sharedPreferences.getString(MED6_KEY, ""))
        med7ET!!.setText(sharedPreferences.getString(MED7_KEY, ""))
        med8ET!!.setText(sharedPreferences.getString(MED8_KEY, ""))
        med9ET!!.setText(sharedPreferences.getString(MED9_KEY, ""))
        med10ET!!.setText(sharedPreferences.getString(MED10_KEY, ""))
        quan1_et!!.setText(sharedPreferences.getString(QUANmed1_KEY, ""))
        quan2_et!!.setText(sharedPreferences.getString(QUANmed2_KEY, ""))
        quan3_et!!.setText(sharedPreferences.getString(QUANmed3_KEY, ""))
        quan4_et!!.setText(sharedPreferences.getString(QUANmed4_KEY, ""))
        quan5_et!!.setText(sharedPreferences.getString(QUANmed5_KEY, ""))
        quan6_et!!.setText(sharedPreferences.getString(QUANmed6_KEY, ""))
        quan7_et!!.setText(sharedPreferences.getString(QUANmed7_KEY, ""))
        quan8_et!!.setText(sharedPreferences.getString(QUANmed8_KEY, ""))
        quan9_et!!.setText(sharedPreferences.getString(QUANmed9_KEY, ""))
        quan10_et!!.setText(sharedPreferences.getString(QUANmed10_KEY, ""))

        //prevents user from changing med
        med1TV = root.findViewById(R.id.med1_textview)
        med1TV!!.text = med1ET!!.text.toString()
        if (med1ET!!.text.isEmpty()) {
        } else {
            med1ET!!.visibility = View.GONE
            med1TV!!.visibility = View.VISIBLE}

        med2TV = root.findViewById(R.id.med2_textview)
        med2TV!!.text = med2ET!!.text.toString()
        if (med2ET!!.text.isEmpty()) {
        } else {
            med2ET!!.visibility = View.GONE
            med2TV!!.visibility = View.VISIBLE}

        med3TV = root.findViewById(R.id.med3_textview)
        med3TV!!.text = med3ET!!.text.toString()
        if (med3ET!!.text.isEmpty()) {
        } else {
            med3ET!!.visibility = View.GONE
            med3TV!!.visibility = View.VISIBLE}

        med4TV = root.findViewById(R.id.med4_textview)
        med4TV!!.text = med4ET!!.text.toString()
        if (med4ET!!.text.isEmpty()) {
        } else {
            med4ET!!.visibility = View.GONE
            med4TV!!.visibility = View.VISIBLE}

        med5TV = root.findViewById(R.id.med5_textview)
        med5TV!!.text = med5ET!!.text.toString()
        if (med5ET!!.text.isEmpty()) {
        } else {
            med5ET!!.visibility = View.GONE
            med5TV!!.visibility = View.VISIBLE}

        med6TV = root.findViewById(R.id.med6_textview)
        med6TV!!.text = med6ET!!.text.toString()
        if (med6ET!!.text.isEmpty()) {
        } else {
            med6ET!!.visibility = View.GONE
            med6TV!!.visibility = View.VISIBLE}

        med7TV = root.findViewById(R.id.med7_textview)
        med7TV!!.text = med7ET!!.text.toString()
        if (med7ET!!.text.isEmpty()) {
        } else {
            med7ET!!.visibility = View.GONE
            med7TV!!.visibility = View.VISIBLE}

        med8TV = root.findViewById(R.id.med8_textview)
        med8TV!!.text = med8ET!!.text.toString()
        if (med8ET!!.text.isEmpty()) {
        } else {
            med8ET!!.visibility = View.GONE
            med8TV!!.visibility = View.VISIBLE}

        med9TV = root.findViewById(R.id.med9_textview)
        med9TV!!.text = med9ET!!.text.toString()
        if (med9ET!!.text.isEmpty()) {
        } else {
            med9ET!!.visibility = View.GONE
            med9TV!!.visibility = View.VISIBLE}

        med10TV = root.findViewById(R.id.med10_textview)
        med10TV!!.text = med10ET!!.text.toString()
        if (med10ET!!.text.isEmpty()) {
        } else {
            med10ET!!.visibility = View.GONE
            med10TV!!.visibility = View.VISIBLE}

        //explains to user that once a med is entered, it cannot be changed
        med1TV!!.setOnClickListener { Toast.makeText(context, "This medication cannot be changed", Toast.LENGTH_LONG).show()}
        med2TV!!.setOnClickListener { Toast.makeText(context, "This medication cannot be changed", Toast.LENGTH_LONG).show()}
        med3TV!!.setOnClickListener { Toast.makeText(context, "This medication cannot be changed", Toast.LENGTH_LONG).show()}
        med4TV!!.setOnClickListener { Toast.makeText(context, "This medication cannot be changed", Toast.LENGTH_LONG).show()}
        med5TV!!.setOnClickListener { Toast.makeText(context, "This medication cannot be changed", Toast.LENGTH_LONG).show()}
        med6TV!!.setOnClickListener { Toast.makeText(context, "This medication cannot be changed", Toast.LENGTH_LONG).show()}
        med7TV!!.setOnClickListener { Toast.makeText(context, "This medication cannot be changed", Toast.LENGTH_LONG).show()}
        med8TV!!.setOnClickListener { Toast.makeText(context, "This medication cannot be changed", Toast.LENGTH_LONG).show()}
        med9TV!!.setOnClickListener { Toast.makeText(context, "This medication cannot be changed", Toast.LENGTH_LONG).show()}
        med10TV!!.setOnClickListener { Toast.makeText(context, "This medication cannot be changed", Toast.LENGTH_LONG).show()}

        return root
    }

    //applies sharedpreference values to keys
    private val TextWatcher1 = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(MED1_KEY, med1ET!!.text.toString())
            editor.apply()}
        override fun afterTextChanged(s: Editable?) {}}

    private val TextWatcher2 = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(MED2_KEY, med2ET!!.text.toString())
            editor.apply()}
        override fun afterTextChanged(s: Editable?) {}}

    private val TextWatcher3 = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(MED3_KEY, med3ET!!.text.toString())
            editor.apply()}
        override fun afterTextChanged(s: Editable?) {}}

    private val TextWatcher4 = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(MED4_KEY, med4ET!!.text.toString())
            editor.apply()}
        override fun afterTextChanged(s: Editable?) {}}

    private val TextWatcher5 = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(MED5_KEY, med5ET!!.text.toString())
            editor.apply()}
        override fun afterTextChanged(s: Editable?) {}}

    private val TextWatcher6 = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(MED6_KEY, med6ET!!.text.toString())
            editor.apply()}
        override fun afterTextChanged(s: Editable?) {}}

    private val TextWatcher7 = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(MED7_KEY, med7ET!!.text.toString())
            editor.apply()}
        override fun afterTextChanged(s: Editable?) {}}

    private val TextWatcher8 = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(MED8_KEY, med8ET!!.text.toString())
            editor.apply()}
        override fun afterTextChanged(s: Editable?) {}}

    private val TextWatcher9 = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(MED9_KEY, med9ET!!.text.toString())
            editor.apply()}
        override fun afterTextChanged(s: Editable?) {}}

    private val TextWatcher10 = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(MED10_KEY, med10ET!!.text.toString())
            editor.apply()}
        override fun afterTextChanged(s: Editable?) {}}

    private val TextWatcher11 = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(QUANmed1_KEY, quan1_et!!.text.toString())
            editor.apply()}
        override fun afterTextChanged(s: Editable?) {}}

    private val TextWatcher12 = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(QUANmed2_KEY, quan2_et!!.text.toString())
            editor.apply()}
        override fun afterTextChanged(s: Editable?) {}}

    private val TextWatcher13 = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(QUANmed3_KEY, quan3_et!!.text.toString())
            editor.apply()}
        override fun afterTextChanged(s: Editable?) {}}

    private val TextWatcher14 = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(QUANmed4_KEY, quan4_et!!.text.toString())
            editor.apply()}
        override fun afterTextChanged(s: Editable?) {}}

    private val TextWatcher15 = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(QUANmed5_KEY, quan5_et!!.text.toString())
            editor.apply()}
        override fun afterTextChanged(s: Editable?) {}}

    private val TextWatcher16 = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(QUANmed6_KEY, quan6_et!!.text.toString())
            editor.apply()}
        override fun afterTextChanged(s: Editable?) {}}

    private val TextWatcher17 = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(QUANmed7_KEY, quan7_et!!.text.toString())
            editor.apply()}
        override fun afterTextChanged(s: Editable?) {}}

    private val TextWatcher18 = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(QUANmed8_KEY, quan8_et!!.text.toString())
            editor.apply()}
        override fun afterTextChanged(s: Editable?) {}}

    private val TextWatcher19 = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(QUANmed9_KEY, quan9_et!!.text.toString())
            editor.apply()}
        override fun afterTextChanged(s: Editable?) {}}

    private val TextWatcher20 = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(QUANmed10_KEY, quan10_et!!.text.toString())
            editor.apply()}
        override fun afterTextChanged(s: Editable?) {}}

    //hides keyboard
    override fun onResume() {
        super.onResume()
        hideKeyboard()}
}