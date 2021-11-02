package com.lemillion.minke

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import com.lemillion.minke.data.entity.Account
import com.lemillion.minke.data.entity.AccountType
import com.lemillion.minke.ui.AccountList
import org.junit.Rule
import org.junit.Test

class AccountViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testAccountListItem() {
        // Start the app
        val account = getTestAccount()
        val accounts = listOf(account)
        composeTestRule.setContent {
            AccountList(accounts)
        }
        Thread.sleep(5000)

        composeTestRule.onNode(hasText(account.toString())).assertIsDisplayed()
    }

    private fun getTestAccount() = Account(AccountType.SAVINGS, "Test Account", "123456789")
}