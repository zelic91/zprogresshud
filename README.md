ZProgressHUD
============
![alt tag]()

ZProgressHUD is a progress dialog with HUD style for Android.

### Import the projects
To use the HUD, clone this project and import it into your workspace. Then reference it from your main project as a **library**.

### Initialize the HUD
ZProgressHUD is based on singleton pattern, you must initialize it before using:

`
ZProgressHUD progressHUD = ZProgressHUD.getInstance(context);
`

Please notice that you must pass a context to the getInstance() method.

### Show the HUD
Just call `show()` as a normal dialog.

### Dismiss the HUD
You can dismiss the HUD in 2 ways: success and failure. For each of those, you can set your custom message for the HUD.

`progressHUD.dismissWithSuccess("Done");
progressHUD.dismissWithFailure("Spoil");
`

Default message is set to __"Success"__ and __"Failure"__ for success and failure respectively.

### Reset the HUD
Please call `reset()` to refresh the HUD in order to reuse the same instance.

===================
Please feel free to drop me an email at [thuongnh.uit@gmail.com](thuongnh.uit@gmail.com) to improve the HUD.