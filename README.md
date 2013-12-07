ZProgressHUD
============
![alt tag](https://raw.github.com/zelic91/zprogresshud/master/gear.png)

![alt tag](https://raw.github.com/zelic91/zprogresshud/master/fade.png)

![alt tag](https://raw.github.com/zelic91/zprogresshud/master/simple_round.png)


ZProgressHUD is a progress dialog with HUD style for Android.

### Import the projects
To use the HUD, clone this project and import it into your workspace. Then reference it from your main project as a **library**.

### Initialize the HUD
ZProgressHUD is based on singleton pattern, you must initialize it before using:

`
ZProgressHUD progressHUD = ZProgressHUD.getInstance(context);
`

Please notice that you must pass a context to the getInstance() method.

### Set HUD message
You can set your custom message (instead of "Loading ..." by default) by calling `setMessage()` method. Be aware of the length of the message, it will be cut if too long.

### Set spinner type
At the moment, there are 3 types of spinner: GEAR_SPINNER, SIMPLE_ROUND_SPINNER and FADED_ROUND_SPINNER. You can set it by calling `setSpinnerType()`.

### Show the HUD
Just call `show()` as a normal dialog.

### Dismiss the HUD
You can dismiss the HUD in 2 ways: success and failure. For each of those, you can set your custom message for the HUD.

`progressHUD.dismissWithSuccess("Done");
progressHUD.dismissWithFailure("Spoil");
`

Default message is set to __"Success"__ and __"Failure"__ for success and failure respectively.

===================
Please feel free to drop me an email at [thuongnh.uit@gmail.com](thuongnh.uit@gmail.com) to improve the HUD.