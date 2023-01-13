import { Person } from './person';
export interface Movie {
    id?: string;
    title?: string;
    summary?: string;
    rating?: number;
    duration?: number;
    releaseYear?: number;
    genre: string;
    image: string;
    actors: Person[];
    writers: Person[];
    director: Person;
}
