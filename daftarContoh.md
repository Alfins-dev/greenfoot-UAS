
## Contructors

```java
public laser(int rotation){
        setImage("laser.png");
        setRotation(rotation);
    }
```

## fungsi return

```java
public int statPerisai(){
        return perisai;
    }
```

## fungsi berparameter

```java
public int getRandomNumber(int start,int end)
    {
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
```

## logika if..else

```java
public void gerak()
    {
        move(10);
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }else{
            hit();
        }
    }
```

## logika switch..case

```java
    switch(tipeSenjata)
    {
        case 0 : bedil(); break;
        case 1 : dual(); break;
        case 2 : repeater(); break;
        case 3 : tigaArah(); break;
    }
```
## variabel
public:
`public int nyawa=3;`
private:
`private int jedaTembak`
static final:
`public static final float FONTSIZE = 40.0f;`
object instance:
```java
MyWorld w=(MyWorld)getWorld();
int perisai = w.statPerisai();
```
## Perulangan (looping)

```java
for (int i=1; i<4; i++)
    {
    getWorld().addObject(new laser((45*i)-90),getX()+60,getY()+10);
    }
```

## randomization

```java
private void spawnMusuh()
    {
        if (Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new Musuh(), 1000, nomorAcak(50,550));
        }
    }
```

## casting data type

```java
int perisai = w.statPerisai();
```

## keyboard control

```java
if (Greenfoot.isKeyDown("left"))
        {
            move(-6);
        }
```

## animation

```java
private void animate(){
        if (count % animateSpeed == 0)
        {
            if (animateImage == 7)
            {
                animateImage = 1;
            }
            setImage("plane"+animateImage+".png");
            animateImage++;
            getImage().scale(100, 50);
        }
    }
```
