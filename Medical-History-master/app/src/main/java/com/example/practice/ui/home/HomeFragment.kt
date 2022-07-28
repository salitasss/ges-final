package com.example.practice.ui.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.practice.R
import com.example.practice.R.layout.fragment_home
import com.example.practice.Room.UserDatabase
import com.example.practice.adapters.UserAdapter
import com.example.practice.databinding.FragmentHomeBinding
import com.example.practice.hideKeyboard
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    private val myPreference = "myPref"

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

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {

        val binding: FragmentHomeBinding =
            DataBindingUtil.inflate(inflater, fragment_home, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = UserDatabase.getInstance(application).userDao()
        val viewModelFactory = HomeViewModelFactory(dataSource,application)

        val homeViewModel =ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)

        val adapter = UserAdapter()
        binding.productList.adapter = adapter
        val nights = dataSource.getAllNights()
        homeViewModel.nights.observe(viewLifecycleOwner, Observer {
            it?.let {adapter.submitList(it)}})

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val root: View = binding.root

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.homeFragment_to_addFragment)}

        //prevents unresolved reference
        val headerTV_med1 = root.findViewById(R.id.headerTV_med1) as TextView
        val headerTV_med2 = root.findViewById(R.id.headerTV_med2) as TextView
        val headerTV_med3 = root.findViewById(R.id.headerTV_med3) as TextView
        val headerTV_med4 = root.findViewById(R.id.headerTV_med4) as TextView
        val headerTV_med5 = root.findViewById(R.id.headerTV_med5) as TextView
        val headerTV_med6 = root.findViewById(R.id.headerTV_med6) as TextView
        val headerTV_med7 = root.findViewById(R.id.headerTV_med7) as TextView
        val headerTV_med8 = root.findViewById(R.id.headerTV_med8) as TextView
        val headerTV_med9 = root.findViewById(R.id.headerTV_med9) as TextView
        val headerTV_med10 = root.findViewById(R.id.headerTV_med10) as TextView

        sharedPreferences =
            requireActivity().getSharedPreferences(myPreference, Context.MODE_PRIVATE)

        //displays med value entered in MedicationsFragment
        headerTV_med1.text = sharedPreferences.getString(MED1_KEY, "")
        headerTV_med2.text = sharedPreferences.getString(MED2_KEY, "")
        headerTV_med3.text = sharedPreferences.getString(MED3_KEY, "")
        headerTV_med4.text = sharedPreferences.getString(MED4_KEY, "")
        headerTV_med5.text = sharedPreferences.getString(MED5_KEY, "")
        headerTV_med6.text = sharedPreferences.getString(MED6_KEY, "")
        headerTV_med7.text = sharedPreferences.getString(MED7_KEY, "")
        headerTV_med8.text = sharedPreferences.getString(MED8_KEY, "")
        headerTV_med9.text = sharedPreferences.getString(MED9_KEY, "")
        headerTV_med10.text = sharedPreferences.getString(MED10_KEY, "")

        //displays TextView when contains text
        if (headerTV_med1.text.isNotEmpty()) {headerTV_med1.visibility = View.VISIBLE}
        if (headerTV_med2.text.isNotEmpty()) {headerTV_med2.visibility = View.VISIBLE}
        if (headerTV_med3.text.isNotEmpty()) {headerTV_med3.visibility = View.VISIBLE}
        if (headerTV_med4.text.isNotEmpty()) {headerTV_med4.visibility = View.VISIBLE}
        if (headerTV_med5.text.isNotEmpty()) {headerTV_med5.visibility = View.VISIBLE}
        if (headerTV_med6.text.isNotEmpty()) {headerTV_med6.visibility = View.VISIBLE}
        if (headerTV_med7.text.isNotEmpty()) {headerTV_med7.visibility = View.VISIBLE}
        if (headerTV_med8.text.isNotEmpty()) {headerTV_med8.visibility = View.VISIBLE}
        if (headerTV_med9.text.isNotEmpty()) {headerTV_med9.visibility = View.VISIBLE}
        if (headerTV_med10.text.isNotEmpty()) {headerTV_med10.visibility = View.VISIBLE}

        //meds will be truncated in 50dp TextViews
        //snackbar displays entire med at top of screen
        headerTV_med1.setOnClickListener{
            val snackBarView = Snackbar.make(requireView(), headerTV_med1.text.toString(), Snackbar.LENGTH_SHORT)
            val view = snackBarView.view
            val params = view.layoutParams as CoordinatorLayout.LayoutParams
            params.gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP
            view.layoutParams = params
            snackBarView.show()}

        headerTV_med2.setOnClickListener{
            val snackBarView = Snackbar.make(requireView(), headerTV_med2.text.toString(), Snackbar.LENGTH_SHORT)
            val view = snackBarView.view
            val params = view.layoutParams as CoordinatorLayout.LayoutParams
            params.gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP
            view.layoutParams = params
            snackBarView.show()}

        headerTV_med3.setOnClickListener{
            val snackBarView = Snackbar.make(requireView(), headerTV_med3.text.toString(), Snackbar.LENGTH_SHORT)
            val view = snackBarView.view
            val params = view.layoutParams as CoordinatorLayout.LayoutParams
            params.gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP
            view.layoutParams = params
            snackBarView.show()}

        headerTV_med4.setOnClickListener{
            val snackBarView = Snackbar.make(requireView(), headerTV_med4.text.toString(), Snackbar.LENGTH_SHORT)
            val view = snackBarView.view
            val params = view.layoutParams as CoordinatorLayout.LayoutParams
            params.gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP
            view.layoutParams = params
            snackBarView.show()}

        headerTV_med5.setOnClickListener{
            val snackBarView = Snackbar.make(requireView(), headerTV_med5.text.toString(), Snackbar.LENGTH_SHORT)
            val view = snackBarView.view
            val params = view.layoutParams as CoordinatorLayout.LayoutParams
            params.gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP
            view.layoutParams = params
            snackBarView.show()}

        headerTV_med6.setOnClickListener{
            val snackBarView = Snackbar.make(requireView(), headerTV_med6.text.toString(), Snackbar.LENGTH_SHORT)
            val view = snackBarView.view
            val params = view.layoutParams as CoordinatorLayout.LayoutParams
            params.gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP
            view.layoutParams = params
            snackBarView.show()}

        headerTV_med7.setOnClickListener{
            val snackBarView = Snackbar.make(requireView(), headerTV_med7.text.toString(), Snackbar.LENGTH_SHORT)
            val view = snackBarView.view
            val params = view.layoutParams as CoordinatorLayout.LayoutParams
            params.gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP
            view.layoutParams = params
            snackBarView.show()}

        headerTV_med8.setOnClickListener{
            val snackBarView = Snackbar.make(requireView(), headerTV_med8.text.toString(), Snackbar.LENGTH_SHORT)
            val view = snackBarView.view
            val params = view.layoutParams as CoordinatorLayout.LayoutParams
            params.gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP
            view.layoutParams = params
            snackBarView.show()}

        headerTV_med9.setOnClickListener{
            val snackBarView = Snackbar.make(requireView(), headerTV_med9.text.toString(), Snackbar.LENGTH_SHORT)
            val view = snackBarView.view
            val params = view.layoutParams as CoordinatorLayout.LayoutParams
            params.gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP
            view.layoutParams = params
            snackBarView.show()}

        headerTV_med10.setOnClickListener{
            val snackBarView = Snackbar.make(requireView(), headerTV_med10.text.toString(), Snackbar.LENGTH_SHORT)
            val view = snackBarView.view
            val params = view.layoutParams as CoordinatorLayout.LayoutParams
            params.gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP
            view.layoutParams = params
            snackBarView.show()}

//        //meds will be truncated in 50dp TextViews
//        //toast displays entire med in smaller box on the Action Bar
//        //does not obscure Stats table the way snackbar does
//        //setGravity no longer supported in SDK 30 and above
//        //if you decide to use toast instead of snackbar,
//        //change SDK to 29 in build.gradle(:app)
//        headerTV_med1.setOnClickListener {
//            val  toast = Toast.makeText(activity?.applicationContext, headerTV_med1.text.toString(),
//            Toast.LENGTH_SHORT)
//            toast.setGravity(Gravity.TOP,0,0)
//            toast.show()}
//        headerTV_med2.setOnClickListener {
//            val  toast = Toast.makeText(activity?.applicationContext, headerTV_med2.text.toString(),
//                Toast.LENGTH_SHORT)
//            toast.setGravity(Gravity.TOP,0,0)
//            toast.show()}
//        headerTV_med3.setOnClickListener {
//            val  toast = Toast.makeText(activity?.applicationContext, headerTV_med3.text.toString(), Toast.LENGTH_SHORT)
//            toast.setGravity(Gravity.TOP,0,0)
//            toast.show()}
//        headerTV_med4.setOnClickListener {
//            val  toast = Toast.makeText(activity?.applicationContext, headerTV_med4.text.toString(), Toast.LENGTH_SHORT)
//            toast.setGravity(Gravity.TOP,0,0)
//            toast.show()}
//        headerTV_med5.setOnClickListener {
//            val  toast = Toast.makeText(activity?.applicationContext, headerTV_med5.text.toString(), Toast.LENGTH_SHORT)
//            toast.setGravity(Gravity.TOP,0,0)
//            toast.show()}
//        headerTV_med6.setOnClickListener {
//            val  toast = Toast.makeText(activity?.applicationContext, headerTV_med6.text.toString(), Toast.LENGTH_SHORT)
//            toast.setGravity(Gravity.TOP,0,0)
//            toast.show()}
//        headerTV_med7.setOnClickListener {
//            val  toast = Toast.makeText(activity?.applicationContext, headerTV_med7.text.toString(), Toast.LENGTH_SHORT)
//            toast.setGravity(Gravity.TOP,0,0)
//            toast.show()}
//        headerTV_med8.setOnClickListener {
//            val  toast = Toast.makeText(activity?.applicationContext, headerTV_med8.text.toString(), Toast.LENGTH_SHORT)
//            toast.setGravity(Gravity.TOP,0,0)
//            toast.show()}
//        headerTV_med9.setOnClickListener {
//            val  toast = Toast.makeText(activity?.applicationContext, headerTV_med9.text.toString(), Toast.LENGTH_SHORT)
//            toast.setGravity(Gravity.TOP,0,0)
//            toast.show()}
//        headerTV_med10.setOnClickListener {
//            val  toast = Toast.makeText(activity?.applicationContext, headerTV_med10.text.toString(), Toast.LENGTH_SHORT)
//            toast.setGravity(Gravity.TOP,0,0)
//            toast.show()}

        return binding.root
    }

    //enable options menu in this fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)}

    //inflate the menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main, menu)
        super.onCreateOptionsMenu(menu, inflater)}

    //handle item clicks of menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_settings){
            Toast.makeText(activity, "Click a record to edit or delete", Toast.LENGTH_LONG).show()}
        return super.onOptionsItemSelected(item)}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null}

    //hides keyboard
    override fun onResume() {
        super.onResume()
        hideKeyboard()}
}