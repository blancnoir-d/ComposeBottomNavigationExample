package com.saeha.project.composebottomnavigationex

import com.saeha.project.composebottomnavigationex.R

sealed class BottomNavItems(
    val route: String,
    val name: String,
    val icon: Int
) {
    object Contacts : BottomNavItems("contacts", "Contacts", R.drawable.ic_home_black_24dp)
    object Recent : BottomNavItems("recent", "Recent", R.drawable.ic_dashboard_black_24dp)
    object Favorites : BottomNavItems("account", "Favorites", R.drawable.ic_notifications_black_24dp)
}

val navItems = listOf(
    BottomNavItems.Contacts,
    BottomNavItems.Recent,
    BottomNavItems.Favorites
)