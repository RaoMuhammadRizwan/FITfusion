package Exercise

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitfusion.R
import com.example.fitfusion.databinding.ActivityExerciseListBinding

class ExerciseListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExerciseListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val level = intent.getStringExtra("level")
        title = level
        binding.tvLevel.text = level

        val exercises = getExercisesForLevel(level)
        val adapter = ExerciseAdapter(exercises)

        binding.recyclerViewExercises.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewExercises.adapter = adapter
    }

    private fun getExercisesForLevel(level: String?): List<Exercise> {
        return when (level) {
            "Beginner Level" -> listOf(
                Exercise(
                    "180 Jump Squat",
                    "Primary muscles: Glutes, hip flexors, quads",
                    "Easy",
                    imageResId = R.drawable.squat180exercise,
                    "1. Stand with your feet a little wider than shoulder-width apart, your toes pointing slightly outward, and sit back.\n" +
                            "2. Push through the heels to jump up, spinning to the left 180 degrees. " +
                            "3. Land on your toes with your knees slightly bent and squat.\n" +
                            "4. Quickly jump up, spinning to the right, and go back into the squat position.\n" +
                            "5. Repeat until the set is complete."
                ),
                Exercise(
                    "Abdominal Bridge",
                    "Primary muscles: Core",
                    "Easy",
                    R.drawable.abdominalbridgeexercise,
                    "1. Lie on your stomach with your legs fully extended and your forearms on the mat.\n" +
                            "2. Engage your core and lift your hips.\n" +
                            "3. Pause for 2 seconds, then return to the starting position.\n" +
                            "4. Repeat until the set is complete."
                ),
                Exercise(
                    "Ab Stretch",
                    "Primary muscles: Abs",
                    "Easy",
                    R.drawable.abstretchexercise,
                    "1. Lie face down on your mat with your legs straight and your arms in a push up position.\n" +
                            "2. Straighten your arms slowly as you lift your torso.\n" +
                            "3. Hold this position for 20 to 30 seconds."

                ),
                Exercise(
                    "Advanced Bridge",
                    "Primary muscles: Glutes",
                    "Medium",
                    R.drawable.advancedbridgeexercise,
                    "1. Sit on the mat with your knees bent, your arms extended back and your fingers facing away from the body.\n" +
                            "2. Lift your butt off the mat, coming into a tabletop position.\n" +
                            "3. Lower your hips, return to the starting position, and repeat."
                ),
                Exercise(
                    "Alternating Dumbbell Swing",
                    "Primary muscles: Glutes, quads, hamstrings",
                    "Medium",
                    R.drawable.alternatingdumbbellswingexercise,
                    "1. Stand with your feet shoulder-width apart, your toes pointed slightly outward, and hold a dumbbell in your right hand.\n" +
                            "2. Squat and bring the dumbbell between your legs.\n" +
                            "3. Stand up, swing the dumbbell up to about chest height, and switch it to your left hand.\n" +
                            "4. Return to the squat position, and keep alternating hands for the duration of the set."
                ),
                Exercise(
                    "Alternating Side Lunge",
                    "Primary muscles: Glutes, quads, hamstrings, inner thighs",
                    "Medium",
                    R.drawable.alternatingsidelungeexercise,
                    "1. Stand tall with your feet hip-width apart.\n" +
                            "2. Step out to the side with your left leg, bend your left knee and push your hips back.\n" +
                            "3. Return to the starting position and repeat the movement with the right leg.\n" +
                            "4. Keep alternating legs until the set is complete."
                ),
                Exercise(
                    "Alternating Side Lunge Touch",
                    "Primary muscles: Inner thighs, glutes, quads, hamstrings",
                    "Hard",
                    R.drawable.alternatingsidelungetouchexercise,
                    "1. Stand tall with your feet hip-width apart.\n" +
                            "2. Step to the side with your right leg and touch the right foot with your left hand.\n" +
                            "3. Return to the starting position and repeat the movement with the left leg."
                ),
                Exercise(
                    "Alternating Superman",
                    "Primary muscles: Middle back, lower back",
                    "Hard",
                    R.drawable.alternatingsupermanexercise,
                    "1. Lie face down on a mat, with your arms and legs fully extended.\n" +
                            "2. Lift one arm and the opposite leg off the floor, by arching your back.\n" +
                            "3. Hold for a count of 2, return to the starting position and repeat with the opposite arm and leg.\n" +
                            "4. Alternate until the set is complete."
                ),
                Exercise(
                    "Ankle Circles",
                    "Primary muscles: Ankles",
                    "Hard",
                    R.drawable.anklecirclesexercise,
                    "1. Stand upright with your feet hip-width apart and your arms by your sides.\n" +
                            "2. Shift your weight to the right leg and point your left toes down into the ground.\n" +
                            "3. Start rotating your left foot, making small circles with your ankles.\n" +
                            "4. Repeat the exercise with your right foot."
                ),
                Exercise(
                    "Ankle Hops",
                    "Primary muscles: Calves",
                    "Medium",
                    R.drawable.anklehopsexercise,
                    "1. Stand upright with your feet hip-width apart and your arms by your sides.\n" +
                            "2. Shift your weight to the right leg and point your left toes down into the ground.\n" +
                            "3. Start rotating your left foot, making small circles with your ankles.\n" +
                            "4. Repeat the exercise with your right foot."
                )

            )

            "Intermediate Level" -> listOf(
                Exercise(
                    "Ankle Tap Push Ups",
                    "Primary muscles: Core",
                    "Medium",
                    R.drawable.ankletappushupsexercise,
                    "1. Start in a push up position, with your hands under your shoulders and your legs extended back.\n" +
                            "2. Start bending your elbows and lower your chest until it’s just above the floor.\n" +
                            "3. As you push back to the starting position, lift your hips, and touch your left ankle with your right hand.\n" +
                            "4. Return to the push up position and repeat on the opposite side.\n" +
                            "5. Keep alternating sides until the set is complete."
                ),
                Exercise(
                    "Arm Circles",
                    "Primary muscles: Shoulders",
                    "Medium",
                    R.drawable.armcirclesexercise,
                    "1. Stand straight with your feet shoulder-width apart.\n" +
                            "2. Raise and extend your arms to the sides without bending the elbows.\n" +
                            "3. Slowly rotate your arms forward, making small circles of about 1 foot in diameter.\n" +
                            "4. Complete a set in one direction and then switch, rotating backward."
                ),
                Exercise(
                    "Bent Over Twist",
                    "Primary muscles: Obliques",
                    "Expert",
                    R.drawable.bentlegjackknifeexercise,
                    "1. Stand straight with your feet slightly wider than shoulder-width apart and raise your arms to the sides.\n" +
                            "2. Bend and rotate your torso to the right, touching your right feet with your left hand.\n" +
                            "3. Return to the starting position and repeat on the other side."
                ),
                Exercise(
                    "Bicycle Crunches",
                    "Primary muscles: Abs, obliques",
                    "Expert",
                    R.drawable.bicyclecrunchesexercise,
                    "1. Lie on your back, lift your shoulders off the mat and raise both legs.\n" +
                            "2. Bring one knee and the opposing elbow close to each other by crunching to one side, and fully extend the other leg.\n" +
                            "3. Return to the starting position and then crunch to the opposite side.\n" +
                            "4. Repeat until the set is complete."
                ),
                Exercise(
                    "Bird Dogs",
                    "Primary muscles: Abs, middle and lower back",
                    "Expert",
                    R.drawable.birdsdogsexercise,
                    "1. Start on your hands and knees with the hands under the shoulders and the knees under the hips.\n" +
                            "2. Extend one leg and the opposite arm at the same time.\n" +
                            "3. Pause for 3 to 5 seconds, return to the starting position, and switch sides.\n" +
                            "4. Continue alternating sides until set is complete."
                ),
                Exercise(
                    "Boat Twist",
                    "Primary muscles: Abs, obliques",
                    "Medium",
                    R.drawable.boattwistexerciseillustration,
                    "1. Sit down on a mat with your knees bent, extend your arms out to the sides and lift your feet off the floor.\n" +
                            "2. Twist your torso to the right, and then reverse the motion, twisting it to the left.\n" +
                            "3. Repeat this movement until the set is complete."
                ),
                Exercise(
                    "Bent Leg Jackknife",
                    "Primary muscles: Abs",
                    "Medium",
                    R.drawable.bentlegjackknifeexercise,
                    "Bent Leg Jackknife Instructions\n" +
                            "1. Lie on your back with your legs straight and your arms extended back.\n" +
                            "2. Raise your torso and bend your knees simultaneously, and then hug your knees with both hands.\n" +
                            "3. Return to the starting position and repeat.\n" +
                            "\n"
                ),
                Exercise(
                    "Basketball Shots",
                    "Primary muscles: Glutes, abs, quads",
                    "Medium",
                    R.drawable.basketballshotsexercise,
                    "1. Stand with your feet shoulder-width apart and the toes pointing slightly outward.\n" +
                            "2. Bend your knees, press your hips back, and take both hands close to your right foot.\n" +
                            "3. Jump up and extend your arms above your head and to the left.\n" +
                            "4. Land with your knees slightly bent and go back into the squat position.\n" +
                            "5. Repeat and then switch sides."
                ),
                Exercise(
                    "Band Leg Abduction Crunch ",
                    "Primary muscles: Abs, outer thighs",
                    "Expert",
                    R.drawable.bandlegcrunchexercise,
                    "1. Lie on the mat, place a resistance band around both legs and raise the legs toward the ceiling.\n" +
                            "2. Lift your shoulders, open the legs and chop your hands through your legs.\n" +
                            "3. Lower your torso, close the legs and return to the starting position.\n" +
                            "4. Repeat until the set is complete."
                ),
                Exercise(
                    "Band Reverse Plank",
                    "Primary muscles: Arms, glutes, core",
                    "Hard",
                    R.drawable.bandreverseplankexercise,
                    "1. Sit on the mat with your legs extended, place a band around your waist, extend your arms back with your fingers facing the body, and secure the band under your hands.\n" +
                            "2. Lift your butt off the mat and squeeze the glutes.\n" +
                            "3. Lower the hips to return to the starting position and repeat."
                ),

                )
//
            "Advanced Level" -> listOf(
                Exercise(
                    "Around The Worlds",
                    "Primary muscles: Chest",
                    "Easy",
                    imageResId = R.drawable.aroundtheworldsexercise,
                    "1. Lie down on a mat with a dumbbell in each hand, your arms by your sides, and the palms of your hands facing the ceiling.\n" +
                            "2. Pull your arms away from the body in a semi-circular movement, and bring the dumbbells over your head.\n" +
                            "3. Reverse the movement to return to the starting position, and repeat."
                ),
                Exercise(
                    "Ankle Tap Push Ups",
                    "Primary muscles: Core",
                    "Easy",
                    R.drawable.ankletappushupsexercise,
                    "1. Start in a push up position, with your hands under your shoulders and your legs extended back.\n" +
                            "2. Start bending your elbows and lower your chest until it’s just above the floor.\n" +
                            "3. As you push back to the starting position, lift your hips, and touch your left ankle with your right hand.\n" +
                            "4. Return to the push up position and repeat on the opposite side.\n" +
                            "5. Keep alternating sides until the set is complete."
                ),
                Exercise(
                    "Asymmetrical Push Up",
                    "Primary muscles: Chest",
                    "Easy",
                    R.drawable.asymmetricalpushupexercise,
                    "1. Start in a push up position with your legs extended back and the hands below the shoulders.\n" +
                            "2. Place your left forearm on the mat, with the elbow directly under the shoulder, and start bending your right elbow until your chest is just above the floor.\n" +
                            "3. Push back to the starting position, repeat, and then switch sides."

                ),
                Exercise(
                    "Butterfly Dips",
                    "Primary muscles: Triceps, shoulders, chest",
                    "Medium",
                    R.drawable.butterflydipsexercise,
                    "1. Sit on the mat with your feet together, place your hands behind you with your fingers facing forward, bend your knees and let your thighs fall open.\n" +
                            "2. Straighten your arms as you press your hips up and bring both knees together.\n" +
                            "3. Bend your elbows and lower your body back to the starting position.\n" +
                            "4. Repeat until the set is complete."
                ),
                Exercise(
                    "Balance Chop",
                    "Primary muscles: Abs, obliques, lower back",
                    "Medium",
                    R.drawable.balancechopexercise,
                    "1. Stand straight with your feet wide and hold a dumbbell with both hands.\n" +
                            "2. Rotate your torso to the left and raise the dumbbell above your head.\n" +
                            "3. Lift your right knee as you rotate your torso to the right, and bring the dumbbell diagonally across the body until it’s close to your right hip.\n" +
                            "4. Repeat and then switch sides."
                ),
                Exercise(
                    "Back Stretch",
                    "Primary muscles: Lower back",
                    "Medium",
                    R.drawable.backextensionsexercise,
                    "1. Start on all fours, positioning your hands directly under your shoulders and your knees under your hips.\n" +
                            "2. Drop your head and pull the abs in, rounding your back and neck.\n" +
                            "3. Hold for 10 seconds.\n" +
                            "4. Raise your head and curve your back down toward the floor.\n" +
                            "5. Hold for another 10 seconds and repeat."
                ),
                Exercise(
                    "Back Extensions",
                    "Primary muscles: Middle and lower back",
                    "Hard",
                    R.drawable.backextensionsexercise,
                    "1. Lie face down on a mat, with your legs fully extended and your hands supporting your head.\n" +
                            "2. Lift your torso up with the help of your back muscles.\n" +
                            "3. Hold for a count of 2 and return to the starting position.\n" +
                            "4. Repeat until set is complete."
                ),
                Exercise(
                    "Alternating Superman",
                    "Primary muscles: Middle back, lower back",
                    "Hard",
                    R.drawable.alternatingsupermanexercise,
                    "1. Lie face down on a mat, with your arms and legs fully extended.\n" +
                            "2. Lift one arm and the opposite leg off the floor, by arching your back.\n" +
                            "3. Hold for a count of 2, return to the starting position and repeat with the opposite arm and leg.\n" +
                            "4. Alternate until the set is complete."
                ),
                Exercise(
                    "Boat Pose",
                    "Yoga",
                    "Hard",
                    R.drawable.boatpose,
                    "1. Sit on the mat with your legs fully extended and lean your torso back.\n" +
                            "2. Raise both legs to a 45-degree angle and reach your arms to the front, keeping them parallel to the floor.\n" +
                            "3. Stay in boat pose for 30 seconds to 1 minute."
                ),
                Exercise(
                    "Bound Angle Pose",
                    "Yoga",
                    "Medium",
                    R.drawable.boundanglepose,
                    "1. Sit down on the mat, bend your knees, press the soles of your feet together, and drop your knees out to the sides.\n" +
                            "2. Lengthen your torso, grasp your big toes and stay in bound angle pose for 1 minute to 2 minutes."
                ),
            )

            "Expert Level" -> listOf(
                Exercise(
                    "Breakdancer Kick",
                    "Primary muscles: Core, shoulders",
                    "Expert",
                    R.drawable.breakdancerkickexercise,
                    "1. Get down on your hands and knees and lift your knees a few inches off the floor.\n" +
                            "2. Lift your left hand and your right foot off the floor, rotate your hips to the left, place your left heel on the floor, and kick your right leg to the left.\n" +
                            "3. Rotate your hips to the right and return to the starting position.\n" +
                            "4. Switch sides and repeat."
                ),
                Exercise(
                    "Up Down Plank",
                    "Primary muscles: Core, arms",
                    "Expert",
                    R.drawable.updownplankexercise,
                    "1. Start in a plank position, with your wrists under your shoulders and your feet hip-width apart.\n" +
                            "2. Bend your left arm, place your left elbow on the mat and then bend your right arm and place your right elbow on the mat.\n" +
                            "3. Place your left hand on the mat, straighten your left arm and then place your right hand on the mat and straighten your right arm.\n" +
                            "4. Switch sides and repeat this up and down movement until the set is complete.\n"
                ),
                Exercise(
                    "Tabletop Reverse Pike",
                    "Primary muscles: Arms, core",
                    "Expert",
                    R.drawable.tabletopreversepikeexercise,
                    "1. Sit on the mat with your knees bent, your arms extended back, your fingers facing the body, and your feet hip-width apart.\n" +
                            "2. Lift your butt off the mat, coming into a tabletop position.\n" +
                            "3. Lower your hips, straighten the legs and lengthen the spine.\n" +
                            "4. Raise your hips, lift your torso and return to the tabletop position.\n" +
                            "5. Repeat."
                ),
                Exercise(
                    "Dumbbell Triceps Kickback",
                    "Primary muscles: Triceps",
                    "Expert",
                    R.drawable.dumbbelltricepskickbackexercise,
                    "1. Grab a set of dumbbells, bring your torso forward and bend your knees slightly.\n" +
                            "2. Bring your elbows up, so that your upper arms are parallel to the floor, and kick back until your arms are fully extended.\n" +
                            "3. Slowly lower the weights to the starting position.\n" +
                            "4. Repeat."
                ),
                Exercise(
                    "Triceps Stretch",
                    "Primary muscles: Triceps",
                    "Expert",
                    R.drawable.tricepsstretchexercise,
                    "1. Stand straight with your feet hip-width apart. Lift and bend one arm until your hand is in the middle of the upper back.\n" +
                            "2. Grasp the elbow with the other hand and gently pull.\n" +
                            "3. Hold for 10 to 20 seconds and repeat on the other side."
                ),
                Exercise(
                    "Decline Push Up",
                    "Primary muscles: Chest",
                    "Expert",
                    R.drawable.declinepushupexercise,
                    "1. Start in a plank position, with your wrists under your shoulders and your feet hip-width apart, and place your feet on top of a step.\n" +
                            "2. Bend your elbows and lower your chest until it’s just above the floor.\n" +
                            "3. Push back to the starting position, and repeat until the set is complete."
                ),
                Exercise(
                    "Chest Press With Legs Extended",
                    "Primary muscles: Chest, abs",
                    "Expert",
                    R.drawable.chestpresswithlegsextendedexercise,
                    "1. Lie on your back, holding a dumbbell in each hand, and raise your legs to a 45-degree angle.\n" +
                            "2. Push the dumbbells up toward the ceiling, with your palms facing your feet and your arms directly above your shoulders.\n" +
                            "3. Bend your elbows, lower your arms and repeat the movement."
                ),
                Exercise(
                    "Crab Toe Touches",
                    "Primary muscles: Lower back, abs",
                    "Expert",
                    R.drawable.crabtoetouchesexercise,
                    "1. Sit on the mat with your knees bent, feet together, and place your hands behind you.\n" +
                            "2. Lift your hips off the mat, kick your right leg up and touch your right foot with your left hand.\n" +
                            "3. Place your right foot on the mat, kick your left leg up and touch your left foot with your right hand.\n" +
                            "4. Keep alternating legs until the set is complete.\n"
                ),
                Exercise(
                    "Cobra Lat Pulldown",
                    "Primary muscles: Lower back",
                    "Expert",
                    R.drawable.cobralatpulldownexercise,
                    "1. Lie on your stomach with your legs and your arms fully extended.\n" +
                            "2. Raise your upper body, bend your arms and bring your shoulder blades together.\n" +
                            "3. Lower your upper body and extend your arms.\n" +
                            "4. Repeat the movement until the set is complete."
                ),
                Exercise(
                    "Bow And Arrow Squat Pull",
                    "Primary muscles: Back",
                    "Expert",
                    R.drawable.bowandarrowpullexercise,
                    "1. Grab a set of dumbbells, squat, and bend your torso until your chest is nearly parallel to the floor.\n" +
                            "2. Twist your torso to the right, bring the left dumbbell between both feet and pull the right dumbbell close to your right shoulder.\n" +
                            "3. Switch sides and repeat."

                )
            )

            else -> emptyList()
        }
    }
}