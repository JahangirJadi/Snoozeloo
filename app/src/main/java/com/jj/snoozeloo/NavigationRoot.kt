package com.jj.snoozeloo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jj.snoozeloo.alarm.presentation.alarmList.MyAlarmListScreenRoot
import com.jj.snoozeloo.alarm.presentation.ringtoneSetting.RingtoneSettingScreenRoot
import com.jj.snoozeloo.alarm.presentation.setAlarm.SetAlarmScreenRoot
import com.jj.snoozeloo.alarm.presentation.setAlarm.SetAlarmViewModel
import org.koin.androidx.compose.koinViewModel
import timber.log.Timber

@Composable
fun NavigationRoot(
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = "alarm"
    ) {
        alarmGraph(navController)
    }

}

private fun NavGraphBuilder.alarmGraph(navController: NavHostController) {
    navigation(
        startDestination = "alarm_list",
        route = "alarm"
    ) {
        composable("alarm_list") {
            MyAlarmListScreenRoot(
                onCreateAlarm = {
                    navController.navigate("set_alarm")
                },
                onEditAlarm = { idAlarm ->
                    navController.navigate("edit_alarm/$idAlarm")
                }
            )
        }

        composable("set_alarm") {



            val viewModel: SetAlarmViewModel = koinViewModel()

            val savedStateHandle by remember{
                mutableStateOf(navController.previousBackStackEntry?.savedStateHandle)
            }

            LaunchedEffect(savedStateHandle) {
                savedStateHandle?.getLiveData<String>("alarmRingtone")?.observeForever {
                    if (it != null) {
                        Timber.i("Setting ringtone >>> On collecting $it")
                        viewModel.updateRingtone(it)
                    } else {
                        Timber.i("Setting ringtone >>> On collecting >>> Nothing here")
                    }
                }
            }


            SetAlarmScreenRoot(
                mViewModel = viewModel,
                onBackPressed = {
                    navController.navigateUp()
                }, onSetRingtone = {
                    if (it != null) {
                        navController.navigate("set_alarm_ringtone/$it")

                    } else {
                        navController.navigate("set_alarm_ringtone")

                    }
                }
            )
        }

        composable("edit_alarm/{idAlarm}") {

            val idAlarm = it.arguments?.getString("idAlarm")!!.toInt()

            val viewModel: SetAlarmViewModel = koinViewModel()



            val savedStateHandle by remember{
                mutableStateOf(navController.previousBackStackEntry?.savedStateHandle)
        }

            LaunchedEffect(savedStateHandle) {
                savedStateHandle?.getLiveData<String>("alarmRingtone")?.observeForever {
                    if (it != null) {
                        Timber.i("Setting ringtone >>> On collecting $it")
                        viewModel.updateRingtone(it)
                    } else {
                        Timber.i("Setting ringtone >>> On collecting >>> Nothing here")
                    }
                }
            }




            SetAlarmScreenRoot(
                onBackPressed = {
                    navController.navigateUp()
                },
                mViewModel = viewModel,
                idAlarm = idAlarm,
                onSetRingtone = {
                    navController.navigate("set_alarm_ringtone?id=$idAlarm")
                }
            )
        }

        composable("set_alarm_ringtone?id={idAlarm}") {

            val idAlarm = it.arguments?.getString("idAlarm")?.toInt()

            RingtoneSettingScreenRoot(
                onRingtoneSelected = { ringtone ->
                    Timber.i("Setting ringtone >>> onRingtoneSelected")
                    navController.previousBackStackEntry?.savedStateHandle?.set(
                        "alarmRingtone",
                        ringtone.name
                    )
                    navController.popBackStack()
                },
                onBackClick = {
                    Timber.i("Setting ringtone >>> onBackClick")
                    navController.navigateUp()
                },
                idAlarm = idAlarm
            )
        }

    }

}
