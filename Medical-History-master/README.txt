Simplified version of an app for storing medical information and daily stats

HideKeyboard:
	activities
	fragments
Root
Drawer Navigation:
	MainActivity
	HomeFragment
	MedicationsFragment
UserAdapter:
	RecyclerView
	Databinding
	TextView conditional visibility - hides empty columns
	TextView conditional text color - warning red text
	RecyclerView item onClickListener navigation to Edit dialog
Fragments
	HomeFragment
		Databinding
		SharedPreferences - display values from MedicationsFragment in TextView header
		TextView conditional visibility - hides empty headers
		TextView onClickListener
			navigation to Add dialog through Floating Access Button (FAB)
			snackbar:
				screen position or gravity
				display TextView value
			toast (optional) setGravity not supported in SDK>=29
		ActionBar Menu - toast simple message
	Add dialog
		SharedPreferences - display values from MedicationsFragment in TextView
		Button onClickListener:
			insert data in database
			navigation to HomeFragment
			toast simple message	
		TextView onClickListener:
			navigation to MedicationsFragment
			toast simple message		
	Edit dialog
		SharedPreferences - display values from MedicationsFragment in TextView
		Button onClickListener:
			Edits or deletes values from database
			navigation to HomeFragment
			toast simple message	
		TextView onClickListener:
			navigation to MedicationsFragment
			toast simple message	
	MedicationsFragment
		SharedPreferences - display values in multiple fragments and dialogs
		TextView onClickListener - toast simple message
		TextWatcher applies SharedPreference values

Thanks to all who shared their code and taught me how to do this.