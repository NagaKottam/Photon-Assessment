package com.Assessment.photon.view.Navigation

const val DETAILS_ARGUMENT_KEY = "details"
sealed class ScreenRoute(val route : String) {
    object SchoolList : ScreenRoute("school_screen")
    object SchoolDetails : ScreenRoute("details_screen/{$DETAILS_ARGUMENT_KEY}"){
        fun passDetails( details: String) : String{
            return "details_screen/$details"
        }
    }
}