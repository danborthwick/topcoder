import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Animation
{
    static class Particle {
        public int velocity;
        public int position;

        public Particle(int velocity, int position)
        {
            this.velocity = velocity;
            this.position = position;
        }
    }
    public static String[] animate(int speed, String input)
    {
        List<Particle> particles = makeParticles(speed, input);
        int length = input.length();
        ArrayList<String> result = new ArrayList<>();
        String lastString = null;

        do {
            String newString = makeString(particles, length);
            if (newString.equals(lastString))
                break;

            result.add(newString);
            update(particles);
            lastString = newString;
        } while (true);

        return result.toArray(new String[result.size()]);
    }

    private static String makeString(List<Particle> particles, int length)
    {
        char[] result = new char[length];
        Arrays.fill(result, '.');

        for (Particle particle : particles) {
            if ((particle.position >= 0) && (particle.position < length))
                result[particle.position] = 'X';
        }

        return new String(result);
    }

    static void update(List<Particle> particles)
    {
        for (Particle particle : particles) {
            particle.position += particle.velocity;
        }
    }


    private static List<Particle> makeParticles(int speed, String input)
    {
        List<Particle> particles = new ArrayList<>();

        for (int i=0; i < input.length(); i++)
        {
            switch (input.charAt(i))
            {
                case 'L':
                    particles.add(new Particle(-speed, i));
                    break;
                case 'R':
                    particles.add(new Particle(speed, i));
                    break;
            }
        }

        return particles;
    }
}
