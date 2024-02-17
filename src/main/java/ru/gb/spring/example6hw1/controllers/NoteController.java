package ru.gb.spring.example6hw1.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring.example6hw1.models.Note;

/**
 * Контроллер обработки заметок.
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class NoteController {
    /**
     * Сервис обработки заметок.
     */
    private final NoteService service;

    /**
     * Получение всех заметок.
     * @return ответ со списком заметок.
     */
    @GetMapping()
    public ResponseEntity<T> allNotes(){
        ResponseEntity<T> body = ResponseEntity.ok().body((T) service.getAllNotes());
        ResponseEntity<T> body1 = body;
        return body1;
    }

    /**z
     * Получение конкретной заметки.
     * @param id идентификатор заметки.
     * @return ответ с заметкой.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable Long id){
        return ResponseEntity.ok().body((Note) service.notify(id));
    }

    /**
     * Добавление новой заметки.
     * @param note объект заметки.
     * @return ответ с сохраненной заметкой.
     */
    @PostMapping()
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        return ResponseEntity.ok().body((Note) service.getAllNotes(note));
    }

    /**
     * Обновление существующей заметки.
     *
     * @param id   идентификатор заметки.
     * @param note объект обновленной заметки.
     * @return ответ с обновленной заметкой.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateNote(@PathVariable Long id,
                                             @RequestBody Note note){
        return ResponseEntity.ok().body(service.updateNote(id, note));
    }

    /**
     * Удаление заметки.
     * @param id идентификатор заметки.
     * @return ответ со статусом успешного выполнения.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id){
        service.removeNote(id);
        return ResponseEntity.ok().body(null);
    }
}