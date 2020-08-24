package n.com.smartalarmsyatem5;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
//         intent = new Intent(AlarmReceiver.this, QuizActivity.class);
//        startActivity(intent);
        try {
            Intent i=new Intent();
            i.setClassName("n.com.smartalarmsyatem5","n.com.smartalarmsyatem5.QuizActivity");
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


            Toast.makeText(context, "Alarm! Wake up! Wake up!", Toast.LENGTH_LONG).show();
            Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
            if (alarmUri == null)
            {
                alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            }
            Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
            ringtone.play();
//            AlarmReceiver.this.finalize();
            context.startActivity(i);

        }catch (Exception e){
            System.out.println("exception is: "+e);
        }

    }
}