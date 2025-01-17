import 'package:flutter/material.dart';

void main() {
  runApp(const ImgGridScreen());
}

class ImgGridScreen extends StatelessWidget {
  const ImgGridScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Image and GridView Example',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const GridViewExample(),
    );
  }
}

class GridViewExample extends StatelessWidget {
  const GridViewExample({super.key});

  @override
  Widget build(BuildContext context) {
    // List of static image URLs with text
    List<Map<String, String>> bgImagesWithText = [
      {"img": "https://images.pexels.com/photos/235986/pexels-photo-235986.jpeg?auto=compress&cs=tinysrgb", "text": "Nature - Mountains"},
      {"img": "https://images.unsplash.com/photo-1540206395-68808572332f", "text": "Abstract Gradient"},
      {"img": "https://images.unsplash.com/photo-1506748686214-e9df14d4d9d0", "text": "Cityscape - Skyline at night"},
      {"img": "https://images.pexels.com/photos/276092/pexels-photo-276092.jpeg?auto=compress&cs=tinysrgb&w=600", "text": "Minimalist - Clean gradient"},
      {"img": "https://images.unsplash.com/photo-1470229722913-7c0e2dbbafd3", "text": "Space - Galaxy"},
      {"img": "https://images.pexels.com/photos/289586/pexels-photo-289586.jpeg?auto=compress&cs=tinysrgb&w=600", "text": "Ocean - Waves"},
      {"img": "https://images.pexels.com/photos/1323550/pexels-photo-1323550.jpeg?auto=compress&cs=tinysrgb&w=600", "text": "Forest - Nature"},
      {"img": "https://images.pexels.com/photos/268533/pexels-photo-268533.jpeg?auto=compress&cs=tinysrgb&w=600", "text": "Urban - Street"},
      {"img": "https://images.pexels.com/photos/289586/pexels-photo-289586.jpeg?auto=compress&cs=tinysrgb&w=600", "text": "Texture - Wooden"},
      {"img": "https://images.unsplash.com/photo-1446776811953-b23d57bd21aa", "text": "Sunset - Serene beach"},
    ];

    return Scaffold(
      appBar: AppBar(
        title: const Text(
          'Image Grid',
          style: TextStyle(color: Colors.red),
          textAlign: TextAlign.center,
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.all(8.0),
        child: GridView.builder(
          gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
            crossAxisCount: 2, // Number of columns
            crossAxisSpacing: 10.0, // Spacing between columns
            mainAxisSpacing: 10.0, // Spacing between rows
          ),
          itemCount: bgImagesWithText.length,
          itemBuilder: (context, index) {
            return ClipRRect(
              borderRadius: BorderRadius.circular(8.0),
              child: Stack(
                fit: StackFit.expand,
                children: [
                  Image.network(
                    bgImagesWithText[index]['img']!,
                    fit: BoxFit.cover,
                  ),
                  Positioned(
                    bottom: 8.0,
                    left: 8.0,
                    child: Container(
                      color: Colors.black54,
                      padding: const EdgeInsets.symmetric(
                        horizontal: 4.0,
                        vertical: 2.0,
                      ),
                      child: Text(
                        bgImagesWithText[index]['text']!,
                        style: const TextStyle(color: Colors.white, fontSize: 12.0),
                      ),
                    ),
                  ),
                ],
              ),
            );
          },
        ),
      ),
    );
  }
}
